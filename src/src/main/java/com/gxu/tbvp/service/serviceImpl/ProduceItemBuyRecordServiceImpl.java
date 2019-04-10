package com.gxu.tbvp.service.serviceImpl;

import com.gxu.tbvp.mapper.ProduceItemBuyRecordMapper;
import com.gxu.tbvp.mapper.SearchRecordMapper;
import com.gxu.tbvp.mockData.ProduceItemBuyRecord;
import com.gxu.tbvp.service.ProduceItemBuyRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProduceItemBuyRecordServiceImpl extends BaseService<ProduceItemBuyRecord> implements ProduceItemBuyRecordService {
    @Resource
 private ProduceItemBuyRecordMapper produceItemBuyRecordMapper;


    public List<ProduceItemBuyRecord> getALLTourism(){
        List<ProduceItemBuyRecord> produces=new ArrayList<ProduceItemBuyRecord>();
        produces=produceItemBuyRecordMapper.getALLTourism();

        for (ProduceItemBuyRecord produce:produces ){
            produce.setCount(getPeopleCount(produce.getProduceId()));
        }
        return  produces;
    }
    public   Integer getPeopleCount(Integer produceId){

        return produceItemBuyRecordMapper.getPeopleCount(produceId);
    }

}
