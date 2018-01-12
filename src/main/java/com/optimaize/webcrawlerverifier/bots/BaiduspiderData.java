package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Resources:
 * http://help.baidu.com/question?prod_en=master&class=498&id=1000973
 */
public class BaiduspiderData implements CrawlerData {

    private static final Predicate<String> PREDICATE = userAgent -> userAgent.contains("Baiduspider");

    /**
     * Source: http://help.baidu.com/question?prod_en=master&class=498&id=1000973
     * "The hostname of Baiduspider is *.baidu.com or *.baidu.jp. Others are fake hostnames."
     */
    private static final ImmutableSet<String> HOSTNAMES = ImmutableSet.of("baidu.com", "baidu.jp");


    private static final BaiduspiderData INSTANCE = new BaiduspiderData();
    public static BaiduspiderData getInstance() {
        return INSTANCE;
    }
    private BaiduspiderData() {
    }



    @Override
    public String getIdentifier() {
        return "BAIDUSPIDER";
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
        //usually "crawl.baidu.com"
        return HOSTNAMES;
    }

}
