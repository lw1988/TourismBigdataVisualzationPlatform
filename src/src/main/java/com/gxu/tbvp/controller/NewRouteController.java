package com.gxu.tbvp.controller;

import com.gxu.tbvp.Respond.NewRouteRespond;
import com.gxu.tbvp.domain.NewRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewRouteController {
    @Autowired
    private NewRouteRespond newRouteRespond;

    @GetMapping(value = "/NewRoutes")
    public List<NewRoute> routeList(){
        return newRouteRespond.findAll();
    }  //查询所有

    @GetMapping(value = "/NewRoutes/id={id}")
    public List<NewRoute> routeListById(@PathVariable("id") Integer id){
        return newRouteRespond.findById(id);
    }  //查询特定ID路线      //只要是int型都能查


    //按游玩天数查询
    @GetMapping(value = "/NewRoutes/days={days}")
    public List<NewRoute> routeListByDays(@PathVariable("days") Integer days){
        return newRouteRespond.findByDays(days);
    }

    //按出发日期查询
    @GetMapping(value = "/NewRoutes/date={date}")
    public List<NewRoute> routeListByDate(@PathVariable("date") Integer date){
        return newRouteRespond.findByDate(date);
    }

    //按路线查询
    @GetMapping(value = "/NewRoutes/route={route}")
    public List<NewRoute> routeListByRoute(@PathVariable("route") String route){
        return newRouteRespond.findByRoute(route);
    }

    //按出发城市查询
    @GetMapping(value = "/NewRoutes/city={city}")
    public List<NewRoute> routeListByCity(@PathVariable("city") String city){
        return newRouteRespond.findByCity(city);
    }

    //按供应商查询
    @GetMapping(value = "/NewRoutes/company={company}")
    public List<NewRoute> routeListByCompany(@PathVariable("company") String company){
        return newRouteRespond.findByCompany(company);
    }

    //价格区间查询
    @GetMapping(value = "/NewRoutes/price/{p1}-{p2}")
    public List<NewRoute> routeListByPriceBet(@PathVariable("p1") Integer p1, @PathVariable("p2") Integer p2){
        return newRouteRespond.findBetweenPrice(p1, p2);
    }

    //title模糊查询
    @GetMapping(value = "/NewRoutes/title/{t1}")
    public List<NewRoute> findByTitleLike(@PathVariable("t1") String t1){
        return newRouteRespond.findByTitleLike("%"+t1+"%");
    }

    //route模糊查询
    @GetMapping(value = "/NewRoutes/route/{r1}")
    public List<NewRoute> findByRouteLike(@PathVariable("r1") String r1){
        return newRouteRespond.findByRouteLike("%"+r1+"%");
    }

    //一日游多条件查询
    @GetMapping(value = "/NewRoutes/1/{r1}")
    public List<NewRoute> routeListTitleAndDays(@PathVariable("r1") String r1){
        return newRouteRespond.findTitleAndDays(r1);
    }

    @GetMapping(value = "/NewRoutes/{route}/{days}/{date}/{city}/{company}")
    public List<NewRoute> find(@PathVariable("route") String route,@PathVariable("days") Integer days,@PathVariable("date") Integer date,@PathVariable("city") String city,@PathVariable("company") String company){
        return newRouteRespond.find(route,days,date,city,company);
    }
}
