package com.gxu.tbvp.controller;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.service.BuyrecordService;
import com.gxu.tbvp.service.ManagerRoleService;
import com.gxu.tbvp.service.ManagerService;
import com.gxu.tbvp.utils.PasswordHelper;
import org.codehaus.jettison.json.JSONArray;
import org.mortbay.util.ajax.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Resource
    private BuyrecordService buyrecordService;



    @RequestMapping(value="/getSale",method=RequestMethod.GET)
    public String  getSaleTrend(HttpServletRequest request, Buyrecord buyrecord, Model model){
    //    Map<String,Object> map = new HashMap<>();
        List<Integer> List = new ArrayList<>();
        ArrayList<List> li = new ArrayList();


        //int Sale201601 = buyrecordService.countSaleByTime(1,2016);
        for(int y=2016;y<=2018;y++) {
            for (int i = 1; i <= 12; i++) {
                List.add(buyrecordService.countSaleByTime(i, y));
  //              System.out.println("++++++++++++++++++++++++++++++++++++++++++++++"+buyrecordService.countSaleByTime(i, y));
                //List.add(Sale201601);
            }
        }
        for(int i=0;i<3*12;i=i+12){

            li.add(List.subList(i,i+12));
        }
        //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++"+Sale201601);
        String data = JSON.toString(li);

        return data;
    }

}

