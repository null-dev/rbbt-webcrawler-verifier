package com.optimaize.webcrawlerverifier;

import java.util.Optional;

public interface KnownCrawlerDetector {

    /**
     * @param userAgent see {@link com.optimaize.webcrawlerverifier.bots.KnownHostBotVerifier#check(String, String)}
     * @param ip        see {@link com.optimaize.webcrawlerverifier.bots.KnownHostBotVerifier#check(String, String)}
     *
     * @return absent if none detected.
     */
    Optional<KnownCrawlerResult> detect(String userAgent, String ip);

}
