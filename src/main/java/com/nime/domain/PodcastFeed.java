package com.nime.domain;

public class PodcastFeed {

    private String feedSeriesName;

    private String feedImage;

    public PodcastFeed(String feedSeriesName, String feedImage) {
        this.feedSeriesName = feedSeriesName;
        this.feedImage = feedImage;
    }

    public String getFeedSeriesName() {
        return feedSeriesName;
    }

    public String getFeedImage() {
        return feedImage;
    }
}
