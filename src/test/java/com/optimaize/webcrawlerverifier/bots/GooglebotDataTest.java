package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GooglebotData Specification")
class GooglebotDataTest {

    @Test
    @DisplayName("Identifier must match")
    void testGetIdentifier() {
        assertEquals(GooglebotData.getInstance().getIdentifier(), "GOOGLEBOT");
    }

    @Test
    @DisplayName("UserAgent detection")
    void testGetUserAgentChecker() {
        assertAll(
                () -> assertTrue(GooglebotData.getInstance().getUserAgentChecker().test("foo Googlebot bar")),
                () -> assertFalse(GooglebotData.getInstance().getUserAgentChecker().test("foo Google bar"))
        );
    }

    @Test
    @DisplayName("There are no whitelisted IPs")
    void testGetIps() {
        assertTrue(GooglebotData.getInstance().getIps().isEmpty());
    }

    @Test
    @DisplayName("Accepts googlebot.com as valid hostname")
    void testGetHostnames() {
        assertThat(GooglebotData.getInstance().getHostnames()).containsAll(ImmutableList.of("googlebot.com"));
    }
}