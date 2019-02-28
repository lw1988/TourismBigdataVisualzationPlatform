package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.ProduceSold;

public interface ProduceSoldService extends IService<ProduceSold> {
    PageInfo<ProduceSold> selectByPage(ProduceSold produceSoled, int start, int length);

}
