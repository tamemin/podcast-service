package com.nime.service;

import com.nime.domain.PodcastFeed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PodcastService {

    private RestTemplate restTemplate = new RestTemplate();

    private RSSConverter rssConverter;

    /**
     * Set up the PodcastService with dependencies
     *
     * @param rssConverter
     */
    public PodcastService(RSSConverter rssConverter) {
        this.rssConverter = rssConverter;
    }


    public PodcastFeed getPostcast(String rssURL) {

        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(rssURL, String.class);

            return rssConverter.convertFromRSS(response.getBody());

        } catch (HttpClientErrorException e) {
            throw new PodcastLookupException("Failed to load the source URL",e);
        }

    }
}
