package com.gxu.tbvp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.mapper.ManagerMapper;
import com.gxu.tbvp.mapper.ManagerRoleMapper;
import com.gxu.tbvp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;


@Service("managerService")
public class ManagerServiceImpl extends BaseService<Manager> implements ManagerService {


    @Resource
    private ManagerRoleMapper managerRoleMapper;

    @Override
    public PageInfo<Manager> selectByPage(Manager manager, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Manager.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(manager.getUsername())) {
            criteria.andLike("username", "%" + manager.getUsername() + "%");
        }
        if (manager.getId() != null) {
            criteria.andEqualTo("id", manager.getId());
        }
        if (manager.getEnable() != null) {
            criteria.andEqualTo("enable", manager.getEnable());
        }
        //分页查询
        PageHelper.startPage(page, length);
        List<Manager> managerList = selectByExample(example);
        return new PageInfo<>(managerList);
    }

    @Override
    public Manager selectByUsername(String username) {
        Example example = new Example(Manager.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<Manager> managerList = selectByExample(example);
        if(managerList.size()>0){
            return managerList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
        //删除用户表
        mapper.deleteByPrimaryKey(userid);
        //删除用户角色表
//        Example example = new Example(ManagerRole.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("userid",userid);
//        managerRoleMapper.deleteByExample(example);
    }
}
