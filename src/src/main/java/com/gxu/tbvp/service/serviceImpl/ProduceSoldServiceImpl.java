package com.gxu.tbvp.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceSold;
import com.gxu.tbvp.service.ProduceSoldService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProduceSoldServiceImpl extends BaseService<ProduceSold> implements ProduceSoldService {

    @Override
    public PageInfo<ProduceSold> selectByPage(ProduceSold produceSoled, int start, int length) {
        int page = start/length+1;
        Example example = new Example(ProduceSold.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<ProduceSold> countList = selectByExample(example);
        return new PageInfo<>(countList);
    }

}
