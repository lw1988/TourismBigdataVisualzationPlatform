package com.gxu.tbvp.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceMonthSold;
import com.gxu.tbvp.service.ProduceMonthSoldService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProduceMonthSoldServiceImpl extends BaseService<ProduceMonthSold> implements ProduceMonthSoldService {

    @Override
    public PageInfo<ProduceMonthSold> selectByPage(ProduceMonthSold produceMonthSold, int start, int length) {
        int page = start/length+1;
        Example example = new Example(ProduceMonthSold.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<ProduceMonthSold> countList = selectByExample(example);
        return new PageInfo<>(countList);
    }

}
