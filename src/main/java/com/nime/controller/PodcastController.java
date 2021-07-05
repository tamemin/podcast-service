package com.nime.controller;


import com.nime.domain.PodcastFeed;
import com.nime.service.PodcastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodcastController {

    private PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }



    @GetMapping("/api/podcast")
    public PodcastFeed getPodcast(@RequestParam("rssURL") String rssURL) {

        return podcastService.getPostcast(rssURL);
    }


}
