import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestJsoup {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://jsoup.org").get();
        Element link = doc.select("a").first();
        String relHref = link.attr("href"); // == "/"
        System.out.println(relHref);
        String absHref = link.attr("abs:href"); // "http://jsoup.org/"
        System.out.println(absHref);

    }
}
