package com.gxu.tbvp;

import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.service.ScenicService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScenicServiceTest {
    @Autowired
    ScenicService scenicService;
    @Ignore
    @Test
    public void getScenicByNameTest(){

        int id = scenicService.getScenicByName("千湖岛");
        Assert.assertEquals(3,id);

    }
    @Ignore
    @Test
    public void selectAllScenicsIdTest(){

        int[] idList = scenicService.selectAllScenicsId();
        Assert.assertEquals(2,idList[0]);
    }
    @Ignore
    @Test
    public void selectScenicByKeyTest(){
        String scenic = scenicService.selectScenicByKey(3);
        Assert.assertEquals("千湖岛",scenic);
    }

}
