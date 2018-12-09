package com.gxu.tbvp.service.serviceImpl;

import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.domain.UserRole;
import com.gxu.tbvp.service.ManagerRoleService;
import com.gxu.tbvp.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("managerRoleService")
public class ManagerRoleServiceImpl extends BaseService<ManagerRole> implements ManagerRoleService {
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(ManagerRole managerRole) {
        //删除
        Example example = new Example(ManagerRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("managerid",managerRole.getManagerid());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = managerRole.getRoleid().split(",");
        for (String roleId : roleids) {
            ManagerRole u = new ManagerRole();
            u.setManagerid(managerRole.getManagerid());
            u.setRoleid(roleId);
            mapper.insert(u);
        }
        //更新当前登录的用户的权限缓存
        List<Integer> managerid = new ArrayList<Integer>();
        managerid.add(managerRole.getManagerid());
        myShiroRealm.clearUserAuthByUserId(managerid);
    }
}
