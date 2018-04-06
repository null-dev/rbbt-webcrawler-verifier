package com.optimaize.webcrawlerverifier.bots;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QwantbotData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.toLowerCase(Locale.ENGLISH).contains("qwant-news");

    private static final Set<String> IPS = IntStream.rangeClosed(0, 255).boxed()
            .map(String::valueOf)
            .map(i -> "194.187.171." + i)
            .collect(Collectors.toSet());

    private static final QwantbotData INSTANCE = new QwantbotData();

    public static QwantbotData getInstance() {
        return INSTANCE;
    }

    private QwantbotData() {
    }

    @Override
    public String getIdentifier() {
        return "QWANTBOT";
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
