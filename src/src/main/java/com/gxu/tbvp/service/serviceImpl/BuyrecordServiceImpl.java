package com.gxu.tbvp.service.serviceImpl;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.mapper.BuyrecordMapper;
import com.gxu.tbvp.service.BuyrecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuyrecordServiceImpl extends BaseService<Buyrecord> implements BuyrecordService {

    @Resource
    private BuyrecordMapper buyrecordMapper;

    @Override
    public int insertList(List<Buyrecord> buyrecordList) {
        buyrecordMapper.insertList(buyrecordList);
        return 1;
    }
}
