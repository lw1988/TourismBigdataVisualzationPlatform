package com.gxu.tbvp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.gxu.tbvp.domain.Route;
import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.mapper.RouteMapper;
import com.gxu.tbvp.mapper.ScenicMapper;
import com.gxu.tbvp.service.RouteService;
import com.gxu.tbvp.service.ScenicService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("routeService")
public class RouteServiceImpl extends BaseService<Route> implements RouteService {


    @Resource
    private RouteMapper routeMapper;

    @Override
    public int getRouteByName(String route) {
        Example example = new Example(Route.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(route)){
            criteria.andEqualTo("title", route);
        }
        List<Route> routeList = selectByExample(example);
        if (routeList.size() != 0){
            return routeList.get(0).getId();
        }
        return -1;
    }

    @Override
    public int[] selectAllRouteId() {
        int[] routes = routeMapper.selectAllRouteId();
        return routes;
    }

    @Override
    public String selectRouteByKey(Integer key) {
        return routeMapper.selectRouteByKey(key);
    }

    @Override
    public PageInfo<Route> selectByPage(Route route, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Route.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Route> routeList = selectByExample(example);
        return new PageInfo<>(routeList);
    }

}
