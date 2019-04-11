package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Accessrecord;
import com.gxu.tbvp.domain.RecomendList;

import java.util.List;


public interface RecomendListService extends IService<RecomendList> {



    //获取所有景点
    List<RecomendList> recommendByUser(String user);
}
