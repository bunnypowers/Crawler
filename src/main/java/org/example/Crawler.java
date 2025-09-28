package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
        Document document = Jsoup.connect(url).timeout(5000).get();
        //Indexer
        System.out.println(document.title());
    }
    public static void main(String[] args) {

    }
}