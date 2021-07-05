package com.nime.service;

import com.nime.domain.PodcastFeed;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Converts RSS XML into a <code>PodcastFeed</code>
 */
@Service
public class RSSConverter {

    private XPath xPath;

    private XPathExpression titleExpression;

    private XPathExpression imageExpression;





    @PostConstruct
    public void init() {

        XPath xPath = XPathFactory.newInstance().newXPath();

        try {
            titleExpression = xPath.compile("/rss/channel/title");
            imageExpression = xPath.compile("/rss/channel/image/url");

        } catch (XPathExpressionException e) {

            System.err.println(e.getMessage());

        }

    }

    /**
     * Given an XML document in the string, return the <code>PodcastFeed</code>
     * populated with the required values, title and image.
     *
     * @param rssXMLInput A full XML document of the source RSS channel
     * @return A populated PostcastFeed object
     */
    public PodcastFeed convertFromRSS(String rssXMLInput) {

        try {

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            InputStream is = new ByteArrayInputStream(rssXMLInput.getBytes(StandardCharsets.UTF_8));


            Document xmlDocument = builder.parse(is);

            String title = (String)titleExpression.evaluate(xmlDocument, XPathConstants.STRING);
            String image = (String)imageExpression.evaluate(xmlDocument, XPathConstants.STRING);

            Validate.notBlank(title,"Title was not found");
            Validate.notBlank(image, "Image was not found");

            return new PodcastFeed(title, image);

        } catch (NullPointerException | IllegalArgumentException | ParserConfigurationException |
                IOException | SAXException | XPathExpressionException e) {

            throw new PodcastLookupException("Unable to lookup podcast", e);

        }


    }
}
