package com.itheima;

import com.changgou.bean.Route01;

import com.changgou.dao.RouteDao01;
import com.changgou.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelloWord {
  @Test
    public void test1(){
    System.out.println("adfsdg");

  }
  @Test
  public void fun02()throws Exception{
    RouteDao01 routeDao01 = new RouteDao01();
    String url = "http://www.jinmalvyou.com/search/index/view_type/1/keyword/"+ URLEncoder.encode("国内","utf-8");
    Document document = Jsoup.connect(url).get();
    Elements liEles = document.select(".rl-b-li");
    for (Element liEle : liEles) {
      Route01 route = new Route01();
      Element aEle = liEle.select("a").first();
      String aHref = aEle.attr("href");
      String sourceId =  aHref.substring(aHref.indexOf("=")+1);
      route.setSourceId(sourceId);
      Element imgEle = aEle.select("img").first();
      String rname =  imgEle.attr("title");
      route.setRname(rname);
      Element strongEle = liEle.select("strong").first();
      String price = strongEle.text();
      route.setPrice(Double.parseDouble(price));
      Elements pEle = liEle.select("p").eq(1);
      String routeIntroduce = pEle.attr("title");
      route.setRouteIntroduce(routeIntroduce);
      String srcUrl = imgEle.attr("src");
      int index = srcUrl.lastIndexOf("/");
      String rimage=  srcUrl.substring(index+1);
      route.setRimage(rimage);
      route.setRflag("1");
      route.setRdate(new Date().toLocaleString());
      route.setIsThemeTour("1");
      route.setCid(1);
      route.setSid(5);
      route.setCount(0);
      //保存图片到磁盘
      srcUrl = "http:"+srcUrl;
      String path = "G:/img/"+rimage;
      HttpClientUtils.downloadFile(srcUrl,path);
      //保存数据库
      routeDao01.addRoute(route);
    }
  }
  @Test
  public void fun03()throws Exception{
    try {
      Document document = Jsoup.connect("https://item.jd.com/62102466494.html").get();
      System.out.println(document.select("span.p-price").text());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Test
  public void fun06(){
    // 设置必要参数
    DesiredCapabilities dcaps = new DesiredCapabilities();
    // ssl证书支持
    dcaps.setCapability("acceptSslCerts", true);
    // 截屏支持
    dcaps.setCapability("takesScreenshot", true);
    // css搜索支持
    dcaps.setCapability("cssSelectorsEnabled", true);
    // js支持
    dcaps.setJavascriptEnabled(true);
    // 驱动支持,运行phantomjs模拟浏览器运行软件
    dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"E:\\czbkE\\JavaWeb\\day45-实战项目第五天\\day45-实战项目第五天\\资料\\02_拓展资料\\phantomjs工具模拟浏览器运行软件\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    // // 创建无界面浏览器对象
    WebDriver driver = new PhantomJSDriver(dcaps);
    try {
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.get("https://item.jd.com/62102466494.html");
      Thread.sleep(5000l);
      String html = driver.getPageSource();
      //根据最新资源数据字符串使用Jsoup解析获取Document对象
      Document document = Jsoup.parse(html);
      System.out.println(document.select("span.p-price").text());
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      // 关闭并退出浏览器
      driver.close();
      driver.quit();
    }

  }
}
