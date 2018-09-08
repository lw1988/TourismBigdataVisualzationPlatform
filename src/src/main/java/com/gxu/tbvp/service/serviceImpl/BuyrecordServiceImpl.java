package com.gxu.tbvp.service.serviceImpl;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Produce;
import com.gxu.tbvp.mapper.BuyrecordMapper;
import com.gxu.tbvp.mapper.ProduceMapper;
import com.gxu.tbvp.service.BuyrecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BuyrecordServiceImpl extends BaseService<Buyrecord> implements BuyrecordService {

    @Resource
    private BuyrecordMapper buyrecordMapper;

    @Resource
    private ProduceMapper produceMapper;

    @Override
    public int insertList(List<Buyrecord> buyrecordList) {
        try {
            buyrecordMapper.insertList(buyrecordList);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Produce> selectAllProducePrice() {
        List<Produce> produceList = produceMapper.selectAll();
        return produceList;
    }

    @Override
    public double selectProducePrice(int produceId) {
        double price = produceMapper.selectProducePrice(produceId);
        return price;
    }

    @Override
    public  int updatePrice(List<Produce> produceList) {
        try {
            for (Produce produce:produceList) {
                produceMapper.updateByPrimaryKeySelective(produce);
            }
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int countPeopleByPrice(Map<String, Object> map) {
        int temp = buyrecordMapper.countPeopleByPrice(map);
        return temp;
    }
}
