package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.utils.MyMapper;

import java.util.List;

public interface ScenicMapper extends MyMapper<Scenic> {
    int[] selectAllScenicsId();

    String selectScenicByKey(int key);

    List<Scenic> getProduceByCity(String city);
}