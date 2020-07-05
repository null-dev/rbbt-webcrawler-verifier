package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Resources:
 * http://en.wikipedia.org/wiki/Googlebot
 * https://support.google.com/webmasters/answer/80553
 */
public class GooglebotData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.contains("Googlebot");

    private static final ImmutableSet<String> HOSTNAMES = ImmutableSet.of("googlebot.com", "google.com");


    private static final GooglebotData INSTANCE = new GooglebotData();

    public static GooglebotData getInstance() {
        return INSTANCE;
    }

    private GooglebotData() {
    }


    @Override
    public String getIdentifier() {
        return "GOOGLEBOT";
    }


    @Override
    public Predicate<String> getUserAgentChecker() {
        return PREDICATE;
    }


    @Override
    public Set<String> getIps() {
        return Collections.emptySet();
    }


    @Override
    public Set<String> getHostnames() {
        return HOSTNAMES;
    }
}
