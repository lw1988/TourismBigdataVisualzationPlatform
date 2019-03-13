package com.gxu.tbvp;
import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.domain.RoleResources;
import com.gxu.tbvp.service.ManagerRoleService;
import com.gxu.tbvp.service.RoleResourcesService;
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
public class RoleResourcesServiceTest {
    @Autowired
    RoleResourcesService roleResourcesService;


    @Ignore
    @Test
    public void addRoleResourcesTset(){

        RoleResources roleResources = new RoleResources(4,"1");
        roleResourcesService.addRoleResources(roleResources);
    }



}
