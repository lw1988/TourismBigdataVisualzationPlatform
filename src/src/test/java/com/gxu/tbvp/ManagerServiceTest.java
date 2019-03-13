package com.gxu.tbvp;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.service.ManagerService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
    public class ManagerServiceTest {
    @Autowired
    private ManagerService managerService;

    @Ignore
    @Test
    public void getUsernameTest(){
        Manager manager=managerService.selectByUsername("admin");
        Assert.assertThat(manager.getUsername(),is("admin"));
    }

    @Ignore
    @Test
    public void getUsernameTest2(){
        Manager manager=managerService.selectByUsername("admin");
        Assert.assertEquals("123",manager.getUsername());
    }

}
