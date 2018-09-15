package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Scenic;

public interface ScenicService extends IService<Scenic>  {
    int getScenicByName(String scenic);

    int[] selectAllScenicsId();

    String selectScenicByKey(Integer key);
}
