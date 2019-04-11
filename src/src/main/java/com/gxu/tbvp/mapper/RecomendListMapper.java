package com.gxu.tbvp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gxu.tbvp.domain.RecomendList;
import tk.mybatis.spring.annotation.MapperScan;
import com.gxu.tbvp.utils.MyMapper;

import java.util.List;


public interface RecomendListMapper extends MyMapper<RecomendList> {
//BaseMapper
//      List<RecomendList> selectByProdeceName(Map map);
public List<RecomendList> selectByUsername(String user);


}

