package com.optimaize.webcrawlerverifier;

/**
 * Result returned by the {@link KnownCrawlerDetector#detect} method.
 */
public class KnownCrawlerResult {

    private final String identifier;
    private final KnownCrawlerResultStatus status;

    public KnownCrawlerResult(String identifier, KnownCrawlerResultStatus status) {
        this.identifier = identifier;
        this.status = status;
    }

    /**
     * @see com.optimaize.webcrawlerverifier.bots.CrawlerData#getIdentifier()
     */

    public String getIdentifier() {
        return identifier;
    }

    /**
     */

    public KnownCrawlerResultStatus getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "KnownCrawlerResult{" +
                "identifier='" + identifier + '\'' +
                ", status=" + status +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KnownCrawlerResult result = (KnownCrawlerResult) o;

        if (status != result.status) return false;
        if (!identifier.equals(result.identifier)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

}
