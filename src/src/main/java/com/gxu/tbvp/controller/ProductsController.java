package com.gxu.tbvp.controller;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.service.BuyrecordService;

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

        return compute_1(1);
    }

    @RequestMapping(value="/getVisitsCount",method=RequestMethod.GET)
    public String  getVisitsTrend(HttpServletRequest request, Buyrecord buyrecord, Model model){

        return compute_1(2);
    }

    //计算节假日对销量影响
    @RequestMapping(value="/getHolidaySale",method=RequestMethod.GET)
    public String  getHolidaySale(HttpServletRequest request, Buyrecord buyrecord, Model model){
        return compute_2(1);

    }

    //计算节假日对客流影响
    @RequestMapping(value="/getHolidayCustomers",method=RequestMethod.GET)
    public String  getHolidayCustomers(HttpServletRequest request, Buyrecord buyrecord, Model model){
        return compute_2(2);

    }

    //计算促销对销量和客流影响
    @RequestMapping(value="/getPromoSale_Cus",method=RequestMethod.GET)
    public String  getPromoSale_Cus(HttpServletRequest request, Buyrecord buyrecord, Model model){
        ArrayList<List> li = new ArrayList();
        li.add(compute_3(1,1));//choose=1为日均销售，promo=1为做了促销，
        li.add(compute_3(1,0));
        li.add(compute_3(2,1));
        li.add(compute_3(2,0));//choose=2为日均客流，promo=0为没做促销，
        String data = JSON.toString(li);

        return data;
    }




    public String compute_1(int choose){ //编写按月份计算某数值功能
        List<Integer> List = new ArrayList<>();
        ArrayList<List> li = new ArrayList();

        if(choose==1) {
            for (int y = 2016; y <= 2018; y++) {
                for (int i = 1; i <= 12; i++) {
                    List.add(buyrecordService.countSaleByTime(i, y));
                }
            }
        }
        if(choose==2) {
            for (int y = 2016; y <= 2018; y++) {
                for (int i = 1; i <= 12; i++) {
                    List.add(buyrecordService.countVisitsByTime(i, y));
                }
            }
        }
        for(int i=0;i<3*12;i=i+12){

            li.add(List.subList(i,i+12));
        }
        String data = JSON.toString(li);

        return data;
    }

    public String compute_2(int choose) { //编写按年份计算某年日平均数值功能
        List<Integer> List = new ArrayList<>();
        List<List> li_1 = new ArrayList();
        List<List> li_2 = new ArrayList();
        List<List> li = new ArrayList();
        if (choose == 1) {   //1为某年里日平均销售
            for (int i = 1; i < 1116; i++) {
                List = new ArrayList<>();
                List.add(i);
                List.add(buyrecordService.countHolidaySale(i, 1, 2015));
                li_1.add(List);
            }
            for (int i = 1; i < 1116; i++) {
                List = new ArrayList<>();
                List.add(i);
                List.add(buyrecordService.countHolidaySale(i, 0, 2015));
                li_2.add(List);
            }
        } else if (choose == 2) { //1为某年里日平均客流
            for (int i = 1; i < 1116; i++) {
                List = new ArrayList<>();
                List.add(i);
                List.add(buyrecordService.countHolidayCustomers(i, 1, 2015));
                li_1.add(List);
            }
            for (int i = 1; i < 1116; i++) {
                List = new ArrayList<>();
                List.add(i);
                List.add(buyrecordService.countHolidayCustomers(i, 0, 2015));
                li_2.add(List);
            }

        }

        li.add(li_1);
        li.add(li_2);

        String data = JSON.toString(li);

        return data;
    }

    public List compute_3(int choose, int promo) { //编写促销的影响 按月份的日平均量     因为数据库只有2013年1月到2015年7月的数据，所以取最近一年从7月开始算
        List<Integer> List = new ArrayList();

        if (choose == 1) {   //1为某年里日平均销售
            for (int i = 8; i < 13; i++) {
                List.add(buyrecordService.countPromoSale(promo, i, 2014));//promo为1做了促销活动
            }
            for (int i = 1; i < 8; i++) {
                List.add(buyrecordService.countPromoSale(promo, i, 2015));//promo为1做了促销活动
            }

        } else if (choose == 2) { //2为某年里日平均客流
            for (int i = 8; i < 13; i++) {
                List.add(buyrecordService.countPromoCustomers(promo, i, 2014));//promo为1做了促销活动
            }
            for (int i = 1; i < 8; i++) {
                List.add(buyrecordService.countPromoCustomers(promo, i, 2015));//promo为1做了促销活动
            }
        }
        return List;
    }




}

