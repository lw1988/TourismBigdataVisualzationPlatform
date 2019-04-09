package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Route;
import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.utils.MyMapper;

public interface RouteMapper extends MyMapper<Route> {
    int[] selectAllRouteId();

    String selectRouteByKey(int key);
}