package com.nime;

import com.nime.domain.*;
import com.nime.service.PodcastService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private PodcastService podcastService;

    @Test
    public void getPodcast_returnsPodcast() {

        //arrange
        // set up postcast service to return a known thing
        String rssURL = "https://podcasts.files.bbci.co.uk/m000tsjy.rss";

        //act
        ResponseEntity<PodcastFeed> podcastFeedResponse = restTemplate.getForEntity("/api/podcast?rssURL=" + rssURL, PodcastFeed.class);

        //assert
        assertThat(podcastFeedResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        PodcastFeed podcastFeed = podcastFeedResponse.getBody();

        assertThat(podcastFeed).isNotNull();

        assertThat(podcastFeed.getFeedSeriesName()).isEqualTo("The Northern Bank Job");

        assertThat(podcastFeed.getFeedImage()).isEqualTo("http://ichef.bbci.co.uk/images/ic/3000x3000/p09fkgbx.jpg");

    }





    @Before
    public void setup(){

    }


}
