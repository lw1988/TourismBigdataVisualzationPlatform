package com.gxu.tbvp.controller;

import com.gxu.tbvp.service.SearchRecordService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TourismIndexController {
    @Resource
    private SearchRecordService searchRecordService;
    //添加旅游指数搜索内容
    @RequestMapping(value="/tourismIndexSearch", method = RequestMethod.POST)
    public List<Map> addSearch(HttpServletRequest request, String title ){

        //String title=request.getAttribute("title").toString();
        List<Map> produceTitles=new ArrayList<Map>();
        String username = request.getSession().getAttribute("Username").toString();
        if(StringUtils.isEmpty(title) ){
            produceTitles=searchRecordService.getDefaultSearchData();
        }else {//如果有搜索内容

            searchRecordService.insertSearchRecord(title,new Date(),username);
            produceTitles=searchRecordService.getSearchRecordByTitle(title);
        }

        return produceTitles;
    }
}
