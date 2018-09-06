package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Produce;

import java.util.List;

public interface BuyrecordService extends IService<Buyrecord> {
    int insertList(List<Buyrecord> buyrecordList);

    List<Produce> selectAllProducePrice();

    double selectProducePrice(int produceId);

    int updatePrice(List<Produce> produceList);
}
