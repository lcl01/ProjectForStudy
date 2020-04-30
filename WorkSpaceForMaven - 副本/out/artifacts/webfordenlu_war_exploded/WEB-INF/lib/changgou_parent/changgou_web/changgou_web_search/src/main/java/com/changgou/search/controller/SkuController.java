package com.changgou.search.controller;

import com.changgou.search.Feign.SkuFeign;
import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "search")
@CrossOrigin
public class SkuController {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private SkuFeign skuFeign;
    @GetMapping("list")
    public String search(@RequestParam(required = false) Map searchMap, Model model){
        handlerSearchMap(searchMap);
        Map result = skuFeign.search(searchMap);
        model.addAttribute("result",result);
        model.addAttribute("searchMap",searchMap);
        String url=this.getUrl(searchMap);
        model.addAttribute("url",url);
        Page page = new Page(new Long(result.get("total").toString()),new Integer(result.get("pageSize").toString()),new Integer(result.get("pageSize").toString()));
        model.addAttribute("page",page);
        return"search";
    }

    private void handlerSearchMap(Map<String,String> searchMap) {
        if(searchMap!=null){
            for (Map.Entry<String, String> entry : searchMap.entrySet()) {
                if(entry.getKey().startsWith("spec_")){
                    entry.setValue(entry.getValue().replace("+","%2B"));
                }
            }
        }
    }

    private String getUrl(Map<String,String> searchMap) {
        String url="/search/list";
        if (searchMap!=null) {
            url +="?";
            for (String key : searchMap.keySet()) {
                if (key.indexOf("sort")>-1||"pageNum".equals(key)) {
                    continue;
                }
                url +=key+"="+searchMap.get(key)+"&";

            }
            url=url.substring(0,url.length()-1);
        }
        return url;
    }
}
