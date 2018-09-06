package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Accessrecord;

import java.util.List;

public interface AccessrecordService extends IService<Accessrecord> {

    int bachInsert(List<Accessrecord> accessrecordList);
}
