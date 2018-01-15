package com.optimaize.webcrawlerverifier;

import com.google.common.collect.ImmutableList;
import com.optimaize.webcrawlerverifier.bots.BotCheckerResult;
import com.optimaize.webcrawlerverifier.bots.KnownHostBotVerifier;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public class DefaultKnownCrawlerDetector implements KnownCrawlerDetector {


    private final List<KnownHostBotVerifier> verifiers;

    public DefaultKnownCrawlerDetector(List<KnownHostBotVerifier> verifiers) {
        this.verifiers = ImmutableList.copyOf(verifiers);
    }

    @Override
    public Optional<KnownCrawlerResult> detect(String userAgent, String ip) {
        for (KnownHostBotVerifier verifier : verifiers) {
            BotCheckerResult check = verifier.check(userAgent, ip);
            if (check != BotCheckerResult.IS_NOT) {
                return Optional.of(new KnownCrawlerResult(verifier.getIdentifier(), convert(check)));
            }
        }
        return Optional.empty();
    }

    private KnownCrawlerResultStatus convert(BotCheckerResult check) {
        BotCheckerResult.assertSize(4);
        KnownCrawlerResultStatus.assertSize(3);
        switch (check) {
            case IS:
                return KnownCrawlerResultStatus.VERIFIED;
            case IMPERSONATOR:
                return KnownCrawlerResultStatus.IMPERSONATOR;
            case FAILED:
                return KnownCrawlerResultStatus.FAILED;
            case IS_NOT:
                throw new UnsupportedOperationException("Not convertible!");
            default:
                throw new UnsupportedOperationException(check.name());
        }
    }

}
