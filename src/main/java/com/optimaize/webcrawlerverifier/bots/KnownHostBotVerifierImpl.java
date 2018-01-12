package com.optimaize.webcrawlerverifier.bots;

import com.google.common.cache.Cache;
import com.optimaize.webcrawlerverifier.dns.ReverseDnsVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 *
 */
class KnownHostBotVerifierImpl implements KnownHostBotVerifier {

    private static final Logger log = LoggerFactory.getLogger(KnownHostBotVerifierImpl.class);


    private final CrawlerData crawlerData;

    private final ReverseDnsVerifier dnsVerifier;

    private final Cache<String, BotCheckerResult> cache;

    KnownHostBotVerifierImpl(CrawlerData crawlerData,
                             ReverseDnsVerifier dnsVerifier,
                             Cache<String, BotCheckerResult> dnsResultCache) {
        this.crawlerData = crawlerData;
        this.dnsVerifier = dnsVerifier;
        this.cache = dnsResultCache;
    }


    @Override
    public String getIdentifier() {
        return crawlerData.getIdentifier();
    }

    @Override

    public BotCheckerResult check( String userAgent,  String ip) {
        if (!crawlerData.getUserAgentChecker().test(userAgent)) {
            return BotCheckerResult.IS_NOT;
        } else {
            Set<String> permittedIps = crawlerData.getIps();
            if (permittedIps.contains(ip)) {
                return BotCheckerResult.IS;
            }

            Set<String> permittedHostnames = crawlerData.getHostnames();
            if (!permittedHostnames.isEmpty()) {
                BotCheckerResult ifPresent = cache.getIfPresent(ip);
                if (ifPresent != null) return ifPresent;
                try {
                    BotCheckerResult result = dnsVerifier.verify(ip, permittedHostnames) ? BotCheckerResult.IS : BotCheckerResult.IMPERSONATOR;
                    cache.put(ip, result);
                    return result;
                } catch (Exception e) {
                    log.debug("DNS verification failed", e);
                    return BotCheckerResult.FAILED;
                }
            }

            //couldn't confirm with ip nor with hostname...
            return BotCheckerResult.IMPERSONATOR;
        }
    }

}
