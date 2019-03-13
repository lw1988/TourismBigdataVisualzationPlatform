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

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class modelTest {
    @Autowired
    private ManagerService managerService;

    @Ignore
    @Test
    public void getUsername(){
        Manager manager=managerService.selectByUsername("admin");
        Assert.assertThat(manager.getUsername(),is("admin"));
    }

}
