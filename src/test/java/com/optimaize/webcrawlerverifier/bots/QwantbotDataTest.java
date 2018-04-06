package com.optimaize.webcrawlerverifier.bots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("QwantbotData Specification")
class QwantbotDataTest {

    @DisplayName("Accepts a valid Qwant IP")
    @Test
    void validIpIsValid() {
        assertThat(QwantbotData.getInstance().getIps()).contains("194.187.171.56");
    }

    @DisplayName("Real Qwant User Agent is valid")
    @Test
    void userAgentCheckingWorks() {
        assertTrue(QwantbotData.getInstance().getUserAgentChecker().test("Mozilla/5.0 (compatible; Qwant-news/2.0; +https://www.qwant.com/)"));
    }
}
