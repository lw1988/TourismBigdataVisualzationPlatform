package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.utils.MyMapper;

import java.util.Map;

public interface BuyrecordMapper extends MyMapper<Buyrecord> {
    int countPeopleByPrice(Map<String, Object> map);
}