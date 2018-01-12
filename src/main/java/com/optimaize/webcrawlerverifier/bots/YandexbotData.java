package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Resources:
 * http://yandex.com/bots
 * http://help.yandex.com/search/robots/check-robot.xml#check-robot
 * http://searchenginewatch.com/sew/news/2067357/bye-bye-crawler-blocking-parasites
 */
public class YandexbotData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.contains("Yandex");

    //exactly as documented by yandex:
    private static final ImmutableSet<String> HOSTNAMES = ImmutableSet.of("yandex.ru", "yandex.net", "yandex.com");


    private static final YandexbotData INSTANCE = new YandexbotData();

    public static YandexbotData getInstance() {
        return INSTANCE;
    }

    private YandexbotData() {
    }


    @Override
    public String getIdentifier() {
        return "YANDEXBOT";
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
