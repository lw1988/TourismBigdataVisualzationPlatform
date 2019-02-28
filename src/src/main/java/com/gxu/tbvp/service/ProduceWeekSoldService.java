package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceMonthSold;
import com.gxu.tbvp.domain.ProduceWeekSold;

public interface ProduceWeekSoldService extends IService<ProduceWeekSold> {
    PageInfo<ProduceWeekSold> selectByPage(ProduceWeekSold produceWeekSold, int start, int length);

}
