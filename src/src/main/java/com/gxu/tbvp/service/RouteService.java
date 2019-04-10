package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Route;
import com.gxu.tbvp.domain.Scenic;

public interface RouteService extends IService<Route>  {
    int getRouteByName(String route);

    int[] selectAllRouteId();

    String selectRouteByKey(Integer key);

    PageInfo<Route> selectByPage(Route route, int start, int length);

}
