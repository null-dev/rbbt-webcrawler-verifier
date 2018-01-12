package com.optimaize.webcrawlerverifier.bots;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

/**
 * For the Yahoo search engine bot.
 *
 * Yahoo changes their search provider every now and then. First they run their own (ones they bought),
 * then they let Bing do the job, then Google ...
 *
 * Although they had announced to take their own Slurp offline, they never did. And recently the spidering
 * has increased again.
 *
 * Resources:
 * http://en.wikipedia.org/wiki/Yahoo!_Slurp
 * https://help.yahoo.com/kb/search/slurp-crawling-page-sln22600.html
 * http://webmasters.stackexchange.com/questions/22565/is-there-any-reason-to-allow-yahoo-slurp-to-crawl-my-site
 */
public class YahooslurpData implements CrawlerData {

    //see http://en.wikipedia.org/wiki/Yahoo!_Slurp
    private static final Predicate<String> PREDICATE = userAgent -> {
        return userAgent.contains("Yahoo! Slurp") || userAgent.contains("Yahoo Slurp");
    };

    private static final ImmutableSet<String> HOSTNAMES = ImmutableSet.of(
            //They also recommended the reverse and forward DNS verification method:
            //http://www.ysearchblog.com/2007/06/05/yahoo-search-crawler-slurp-has-a-new-address-and-signature-card/
            //in 2007 they moved from inktomisearch.com to crawl.yahoo.net
            "crawl.yahoo.net", //this used to be the one before switching to bing. i'll leave it in. yahoo changes every now and then.
            "yse.yahoo.net" //this is used as of 2016-02-19 and they resolve back. ("yse" standing for Yahoo Search Engine I suppose)
    );


    private static final YahooslurpData INSTANCE = new YahooslurpData();
    public static YahooslurpData getInstance() {
        return INSTANCE;
    }
    private YahooslurpData() {
    }



    @Override
    public String getIdentifier() {
        return "YAHOOSLURP";
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
