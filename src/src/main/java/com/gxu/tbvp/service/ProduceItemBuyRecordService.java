package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.SearchRecord;
import com.gxu.tbvp.mockData.ProduceItemBuyRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProduceItemBuyRecordService extends IService<ProduceItemBuyRecord> {

    //获取所有景点
    List<ProduceItemBuyRecord> getALLTourism();
    //获取景点对应的购买人数
    Integer getPeopleCount(Integer produceId);

}
