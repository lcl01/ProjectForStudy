package com.lcl.service;

import com.lcl.bean.Route;
import com.lcl.dao.RouteDao;
import com.lcl.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class RouteService {
    @Test
    public void fun01() throws IOException, SQLException {
        RouteDao routeDao = new RouteDao();
        String url="http://www.jinmalvyou.com/search/index/view_type/1/keyword/%E5%9B%BD%E5%86%85/p/2.html";
        Document document = Jsoup.connect(url).get();
        Elements liEles = document.select(".rl-b-li");
        for (Element liEle : liEles) {
            Route route = new Route();
            Element aEle = liEle.select("a").first();
            String aHerf = aEle.attr("href");
            String sourceId=aHerf.substring(aHerf.indexOf("=")+1);
            route.setSourceId(sourceId);
            Element imgEle = aEle.select("img").first();
            String rname=imgEle.attr("title");
            route.setRname(rname);
            Element strongEle= liEle.select("strong").first();
            String price = strongEle.text();
            route.setPrice(Double.parseDouble(price));
            Elements pEle = liEle.select("p").eq(1);
            String routeIntroduce=pEle.attr("title");
            route.setRouteIntroduce(routeIntroduce);
            String srcUrl = imgEle.attr("src");
            int index=srcUrl.lastIndexOf("/");
            String rimage=srcUrl.substring(index+1);
            route.setRimage(rimage);
            route.setRflag("1");
            route.setRdate(new Date().toLocaleString());
            route.setIsThemeTour("1");
            route.setSid(5);
            route.setCid(1);
            route.setCount(0);
            srcUrl="http:"+srcUrl;
            String path="E:/img/"+rimage;
            HttpClientUtils.downloadFile(srcUrl,path);
            routeDao.addRoute(route);
        }
    }
}
