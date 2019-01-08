package com.gxu.tbvp;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.domain.Produce;
import com.gxu.tbvp.service.BuyrecordService;
import com.gxu.tbvp.service.ManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyrecordServiceTest {
    @Autowired
    private BuyrecordService buyrecordService;


    @Test
    public void selectAllProducePriceTest(){
        List<Produce>  list1 = buyrecordService.selectAllProducePrice();
        String name = list1.get(0).getScenics();
        Assert.assertEquals("北京",name);
    }
    @Test
    public void selectByscenicIdTest(){
        List<Buyrecord> list2 = buyrecordService.selectByscenicId(1);
        Buyrecord buyrecord = list2.get(0);
        Assert.assertEquals("1002432",buyrecord.getId());
    }




}