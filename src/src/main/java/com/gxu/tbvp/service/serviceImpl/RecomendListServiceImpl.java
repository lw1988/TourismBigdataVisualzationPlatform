package com.gxu.tbvp.service.serviceImpl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gxu.tbvp.domain.RecomendList;
import com.gxu.tbvp.mapper.RecomendListMapper;
import com.gxu.tbvp.service.RecomendListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecomendListServiceImpl extends BaseService<RecomendList> implements RecomendListService {

    @Resource
    private  RecomendListMapper recomendListMapper;

    @Override
    public List<RecomendList>  recommendByUser(String user){
        List<RecomendList> list = recomendListMapper.selectByUsername(user);

        return list;
    }

//    @Override
//    public List<Produce> selectAllProducePrice() {
//        List<Produce> produceList = produceMapper.selectAll();
//        return produceList;
//    }
}
