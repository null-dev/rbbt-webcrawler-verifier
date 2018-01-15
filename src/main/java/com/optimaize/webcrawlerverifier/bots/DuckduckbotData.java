package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Resources:
 * https://duckduckgo.com/duckduckbot
 */
public class DuckduckbotData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.contains("DuckDuckBot");

    /**
     * As documented by duckduckgo: https://duckduckgo.com/duckduckbot
     */
    private static final ImmutableSet<String> IPS = ImmutableSet.of("72.94.249.34", "72.94.249.35", "72.94.249.36", "72.94.249.37", "72.94.249.38");


    private static final DuckduckbotData INSTANCE = new DuckduckbotData();

    public static DuckduckbotData getInstance() {
        return INSTANCE;
    }

    private DuckduckbotData() {
    }


    @Override
    public String getIdentifier() {
        return "DUCKDUCKBOT";
    }


    @Override
    public Predicate<String> getUserAgentChecker() {
        return PREDICATE;
    }


    @Override
    public Set<String> getIps() {
        return IPS;
    }


    @Override
    public Set<String> getHostnames() {
        return Collections.emptySet();
    }
}
