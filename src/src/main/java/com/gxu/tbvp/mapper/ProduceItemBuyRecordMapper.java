package com.gxu.tbvp.mapper;

import com.gxu.tbvp.mockData.ProduceItemBuyRecord;
import com.gxu.tbvp.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceItemBuyRecordMapper extends MyMapper<ProduceItemBuyRecord> {
    //查询所有景点
    List<ProduceItemBuyRecord> getALLTourism();
    Integer getPeopleCount(@Param("produceId")Integer produceId);

}
