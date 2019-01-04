package com.gxu.tbvp;
import com.gxu.tbvp.domain.Role;
import com.gxu.tbvp.service.RoleService;
import org.junit.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    RoleService roleService;

    @Ignore

    @Test
    public void queryRoleListWithSelectedTest(){
        List<Role> roleList = roleService.queryRoleListWithSelected(3);
        Role role = roleList.get(0);
        Assert.assertEquals("代理",role.getRoledesc());
    }


    @Ignore
    @Test
    public void delRole(){
        Role role = roleService.delRole(1);
    }


}
