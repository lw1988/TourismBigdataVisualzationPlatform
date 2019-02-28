package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceMonthSold;

public interface ProduceMonthSoldService extends IService<ProduceMonthSold> {
    PageInfo<ProduceMonthSold> selectByPage(ProduceMonthSold produceMonthSoled, int start, int length);

}
