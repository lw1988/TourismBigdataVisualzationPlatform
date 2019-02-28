package com.gxu.tbvp.controller;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceSold;
import com.gxu.tbvp.service.ProduceSoldService;
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
    private ProduceSoldService produceSoldService;

    @RequestMapping
    public Map<String,Object> getAll(ProduceSold produceSold, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<ProduceSold>pageInfo = produceSoldService.selectByPage(produceSold,start,4);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }


}
