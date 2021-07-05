package com.nime.service;

import com.nime.domain.PodcastFeed;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RSSConverterTest {

    private RSSConverter rssConverter;

    @Before
    public void init() {
        rssConverter = new RSSConverter();
        rssConverter.init();
    }


    @Test
    public void testConversion() {

        String inputData = "<rss><channel>\n" +
                "    <title>The Northern Bank Job</title>\n" +
                "    <link>http://www.bbc.co.uk/programmes/m000tsjy</link>\n" +
                "    <description>It was the biggest bank heist in British and Irish criminal history. Belfast writer Glenn Patterson has\n" +
                "        unfinished business with the 2004 Northern Bank robbery.\n" +
                "    </description>\n" +
                "    <itunes:summary>It was the biggest bank heist in British and Irish criminal history. Belfast writer Glenn Patterson\n" +
                "        has unfinished business with the 2004 Northern Bank robbery.\n" +
                "    </itunes:summary>\n" +
                "    <itunes:author>BBC Radio 4</itunes:author>\n" +
                "    <itunes:owner>\n" +
                "        <itunes:name>BBC</itunes:name>\n" +
                "        <itunes:email>RadioMusic.Support@bbc.co.uk</itunes:email>\n" +
                "    </itunes:owner>\n" +
                "    <itunes:new-feed-url>https://podcasts.files.bbci.co.uk/m000tsjy.rss</itunes:new-feed-url>\n" +
                "    <language>en</language>\n" +
                "    <ppg:seriesDetails frequency=\"weekly\" daysLive=\"-1\"/>\n" +
                "    <ppg:systemRef systemId=\"pid.brand\" key=\"m000tsjy\"/>\n" +
                "    <ppg:systemRef systemId=\"pid.genre\" key=\"C00017\"/>\n" +
                "    <ppg:systemRef systemId=\"pid.genre\" key=\"C00045\"/>\n" +
                "    <ppg:network id=\"radio4\" name=\"BBC Radio 4\"/>\n" +
                "    <image>\n" +
                "        <url>http://ichef.bbci.co.uk/images/ic/3000x3000/p09fkgbx.jpg</url>\n" +
                "        <title>The Northern Bank Job</title>\n" +
                "        <link>http://www.bbc.co.uk/programmes/m000tsjy</link>\n" +
                "    </image>\n" +
                "</channel></rss>";

        PodcastFeed podcastFeed = rssConverter.convertFromRSS(inputData);
        assertThat(podcastFeed.getFeedSeriesName()).isEqualTo("The Northern Bank Job");
        assertThat(podcastFeed.getFeedImage()).isEqualTo("http://ichef.bbci.co.uk/images/ic/3000x3000/p09fkgbx.jpg");
    }
}
