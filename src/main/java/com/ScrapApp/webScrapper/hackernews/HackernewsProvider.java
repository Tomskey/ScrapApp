package com.ScrapApp.webScrapper.hackernews;


import com.ScrapApp.webScrapper.Connector;
import com.ScrapApp.webScrapper.Provider;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HackernewsProvider implements Provider {

    private static final String URL = "https://news.ycombinator.com/news?p=";
    private Connector connector;

    public HackernewsProvider(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<Elements> extractAllElements() {
        List<Elements> elements = new ArrayList<>();
        for(int i = 1; i < 2; i++) {
            String newUrl = URL + i;
            elements.add(connector.connectToUrl(newUrl).getAllElements());
        }
        return elements;
    }

    @Override
    public String extractHref(Element element) {
        return element.getElementsByClass("storylink").attr("href");
    }

    @Override
    public String extractTitle(Element element) {
        return null;
    }
}
