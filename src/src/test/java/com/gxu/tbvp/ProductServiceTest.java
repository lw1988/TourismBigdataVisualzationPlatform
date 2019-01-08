package com.gxu.tbvp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.gxu.tbvp.service.ProduceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProduceService productService;

    @Test
    public void getScenicByNameTest(){

        Assert.assertEquals(10,productService.getScenicByName("北京天安门广场"));

    }

}
