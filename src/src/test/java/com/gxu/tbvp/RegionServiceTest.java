package com.gxu.tbvp;

import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.domain.Region;
import com.gxu.tbvp.service.ManagerService;
import com.gxu.tbvp.service.RegionService;
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
public class RegionServiceTest {
    @Autowired
    private RegionService regionService;


    @Test
    public void selectProvinceTest(){
        List<Region> list=regionService.selectProvince();
        Assert.assertEquals("湖北省",list.get(0).getName());
    }
    @Test
    public void selectCountProvinceByIdTest(){
        Assert.assertEquals(0,regionService.selectCountProvinceById(3));
    }

}