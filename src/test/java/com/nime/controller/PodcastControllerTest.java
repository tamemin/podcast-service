package com.nime.controller;

import com.nime.domain.PodcastFeed;
import com.nime.service.PodcastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Tests that the Podcast controller is working correctly using MockMvc
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PodcastController.class)
public class PodcastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PodcastService podcastService;

    @Test
    public void getPodcastOk() throws Exception {

        PodcastFeed podcastFeed = new PodcastFeed("Tams blog","image.com/img/tams1.jpg");

        given(podcastService.getPostcast(any(String.class))).willReturn(podcastFeed);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/podcast?rssURL=anything"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tams blog")));
    }



}