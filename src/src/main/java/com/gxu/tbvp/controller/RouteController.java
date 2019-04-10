package com.gxu.tbvp.controller;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Route;
import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.service.RouteService;
import com.gxu.tbvp.service.ScenicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Resource
    RouteService routeService;
    @RequestMapping
    public Map<String,Object> getAll(Route route, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Route> pageInfo = routeService.selectByPage(route, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            routeService.delete(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Route route) {
        try {
            routeService.save(route);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
