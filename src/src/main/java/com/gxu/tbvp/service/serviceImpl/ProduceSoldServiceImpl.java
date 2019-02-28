package com.gxu.tbvp.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceSoled;
import com.gxu.tbvp.service.ProduceSoledService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProduceSoledServiceImpl extends BaseService<ProduceSoled> implements ProduceSoledService {

    @Override
    public PageInfo<ProduceSoled> selectByPage(ProduceSoled produceSoled, int start, int length) {
        int page = start/length+1;
        Example example = new Example(ProduceSoled.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<ProduceSoled> countList = selectByExample(example);
        return new PageInfo<>(countList);
    }

}
