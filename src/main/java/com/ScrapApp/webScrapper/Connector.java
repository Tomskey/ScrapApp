package com.ScrapApp.webScrapper;

import com.ScrapApp.webScrapper.hackernews.HackernewsProvider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class Connector {

    Document document;

    public Document connectToUrl(String url) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Scheduled(fixedRate = 25000)
    public void ScrapFromWeb(){
        Connector connector = new Connector();
        HackernewsProvider hackernewsProvider = new HackernewsProvider(connector);
        hackernewsProvider.extractAllElements()
                .stream()
                .flatMap(Collection::stream)
                .map(hackernewsProvider::extractHref)
                .distinct()
                .forEach(System.out::println);
    }

}
