package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    int MAX_DEPTH=2;
    HashSet<String> urlSet;
    Crawler() {
        urlSet= new HashSet<>();
    }
    public void getPageLinks(String url, int  depth) {
        if (urlSet.contains(url)) {
            return;
        }
        if (depth>MAX_DEPTH) {
            return;
        }
        depth++;
        try {
            Document document = Jsoup.connect(url).timeout(5000).get();
            //Indexer
            Indexer indexer = new Indexer(document, url);
            System.out.println(document.title());
            Elements availableLinksOnPage = document.select("a[href]");
            for (Element currentLink : availableLinksOnPage) {
                getPageLinks(currentLink.attr("abs:href"), depth);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.getPageLinks("https://www.tpointtech.com/", 1);
    }
}