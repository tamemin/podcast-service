## Podcast service

Run up PodcastServiceApplication

perform a HTTP GET of:-

http://localhost:8080//api/podcast?rssURL=https://podcasts.files.bbci.co.uk/m000tsjy.rss

From a web browser, you should see:-

{"feedSeriesName":"The Northern Bank Job","feedImage":"http://ichef.bbci.co.uk/images/ic/3000x3000/p09fkgbx.jpg"}


The IntegrationTest performs the same task as part of the build.

##### To build an uber-jar and run on the command line outside of IDE

```

mvn clean install
cd target
java -jar podcast-service-xxxxxxxx.jar

```






