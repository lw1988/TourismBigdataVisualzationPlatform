package com.gxu.tbvp.controller;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceMonthSold;
import com.gxu.tbvp.domain.ProduceWeekSold;
import com.gxu.tbvp.service.ProduceMonthSoldService;
import com.gxu.tbvp.service.ProduceWeekSoldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/producesold")
public class ProduceSoldController {
    @Resource
    private ProduceMonthSoldService produceMonthSoldService;


    @RequestMapping("/producemonthsold")
    public Map<String,Object> getMonthAll(ProduceMonthSold produceMonthSold, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<ProduceMonthSold>pageInfo = produceMonthSoldService.selectByPage(produceMonthSold,start,8);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
    @Resource
    private ProduceWeekSoldService produceWeekSoldService;

    @RequestMapping("/produceweeksold")
    public Map<String,Object> getWeekAll(ProduceWeekSold produceWeekSold, String draw,
                                         @RequestParam(required = false, defaultValue = "1") int start,
                                         @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<ProduceWeekSold>pageInfo = produceWeekSoldService.selectByPage(produceWeekSold,start,8);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }


}
