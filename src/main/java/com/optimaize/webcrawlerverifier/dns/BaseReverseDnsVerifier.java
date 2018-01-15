package com.optimaize.webcrawlerverifier.dns;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/**
 * Base class implementing one of the methods by calling the other.
 */
public abstract class BaseReverseDnsVerifier implements ReverseDnsVerifier {

    @Override
    public boolean verify(String ip, String allowedHostName) throws IOException {
        return verify(ip, Collections.singleton(allowedHostName));
    }

    @Override
    public boolean verify(String ip, Collection<String> allowedHostNames) throws IOException {
        return false;
    }
}
