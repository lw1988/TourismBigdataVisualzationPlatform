package com.gxu.tbvp.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceMonthSold;
import com.gxu.tbvp.domain.ProduceWeekSold;
import com.gxu.tbvp.service.ProduceMonthSoldService;
import com.gxu.tbvp.service.ProduceWeekSoldService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProduceWeekSoldServiceImpl extends BaseService<ProduceWeekSold> implements ProduceWeekSoldService {

    @Override
    public PageInfo<ProduceWeekSold> selectByPage(ProduceWeekSold produceWeekSold, int start, int length) {
        int page = start/length+1;
        Example example = new Example(ProduceWeekSold.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<ProduceWeekSold> countList = selectByExample(example);
        return new PageInfo<>(countList);
    }

}
