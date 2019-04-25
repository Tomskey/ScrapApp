package com.ScrapApp.webScrapper;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public interface Provider {

    List<Elements> extractAllElements();
    String extractHref(Element element);
    String extractTitle(Element element);
}
