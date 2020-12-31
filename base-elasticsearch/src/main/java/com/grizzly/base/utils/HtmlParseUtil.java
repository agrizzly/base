package com.grizzly.base.utils;

import com.grizzly.base.pojo.Content;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {

    public List<Content> parseJD(String keyword) throws IOException {

        String url = "https://search.jd.com/Search?keyword=" + keyword;
        Document doc = Jsoup.parse(new URL(url),30000);
        ArrayList<Content> list = new ArrayList<>();
        Element element = doc.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        for (Element el : elements){
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            list.add(new Content(title,img,price));
        }
        return list;
    }

    public List<Content> parseBilibili() throws IOException {

        String url = "https://www.bilibili.com/v/popular/rank/all";
        Document doc = Jsoup.parse(new URL(url),30000);
        ArrayList<Content> list = new ArrayList<>();
        Element element = doc.getElementsByClass("rank-list").first();
        Elements elements = element.getElementsByClass("rank-item");
        for (Element el : elements){
            String rank = el.getElementsByClass("num").eq(0).text();
            String title = el.getElementsByClass("title").eq(0).text();
            String href = el.getElementsByTag("a").get(0).attr("href");
            String img = el.getElementsByTag("img").get(0).attr("data-src");
            System.out.println(el.getElementsByTag("img").get(0));
            String pts = el.getElementsByClass("pts").get(0).child(0).text();
            String play = el.getElementsByTag("span").eq(1).text();
            String view = el.getElementsByTag("span").eq(2).text();
            String author = el.getElementsByTag("a").eq(2).text();
//            list.add(new Content(title,img,price));
            System.out.println(rank);
            System.out.println(title);
            System.out.println(href);
            System.out.println(img);
            System.out.println(pts);
            System.out.println(play);
            System.out.println(view);
            System.out.println(author);
            System.out.println("========================================================================================");

        }
        return list;
    }


    public static void main(String[] args) throws IOException {

//        new HtmlParseUtil().parseJD("心理学").forEach(System.out::println);
        new HtmlParseUtil().parseBilibili().forEach(System.out::println);
    }
}
