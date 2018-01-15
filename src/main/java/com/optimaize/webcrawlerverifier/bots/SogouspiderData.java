package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

/**
 * TODO for now not supported, unclear how to identify.
 * <p>
 * <p>
 * <p>
 * Resources:
 * http://searchenginewatch.com/sew/news/2067357/bye-bye-crawler-blocking-parasites
 * http://en.wikipedia.org/wiki/Sogou
 */
public class SogouspiderData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.toLowerCase(Locale.ENGLISH).contains("sogou");

    /**
     * Nah, apparently they don't identify as this or any other domain? Dunno...
     * I'd need a nofficial statement...
     */
    private static final ImmutableSet<String> HOSTNAMES = ImmutableSet.of("sogou.com");


    private static final SogouspiderData INSTANCE = new SogouspiderData();

    public static SogouspiderData getInstance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private SogouspiderData() {
    }


    @Override
    public String getIdentifier() {
        return "SOGOUSPIDER";
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
