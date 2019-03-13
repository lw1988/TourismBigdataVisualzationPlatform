package com.gxu.tbvp;


import com.gxu.tbvp.domain.Resources;
import com.gxu.tbvp.service.ResourcesService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {
    @Autowired
    private ResourcesService resourcesService;

    @Ignore
    @Test
    public void testqueryAll(){
        List<Resources> lists = resourcesService.queryAll();
        Resources resources = lists.get(0);
        String resourceName = resources.getName();
        Assert.assertEquals("123",resourceName);
    }

    @Ignore
    @Test
    public void testqueryAll_1(){
        List<Resources> lists = resourcesService.queryAll();
        Assert.assertEquals(15,lists.size());
    }

    @Ignore
    @Test
    public void queryResourcesListWithSelectedTest(){
        List<Resources> list2 = resourcesService.queryResourcesListWithSelected(3);
        String name = list2.get(0).getName();
        Assert.assertEquals("用户管理",name);
    }
    @Ignore
    @Test
    public void queryResourcesListWithSelectedTest2(){
        List<Resources> list2 = resourcesService.queryResourcesListWithSelected(3);
        String name = list2.get(0).getName();
        Assert.assertEquals("角色管理",name);
    }
}
