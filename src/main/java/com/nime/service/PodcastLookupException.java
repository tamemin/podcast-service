package com.nime.service;

/**
 * Generic catch-all for Podcast lookup failures
 */
public class PodcastLookupException extends RuntimeException{

    public PodcastLookupException(String message) {
        super(message);
    }

    public PodcastLookupException(String message, Throwable cause) {
        super(message, cause);
    }
}
