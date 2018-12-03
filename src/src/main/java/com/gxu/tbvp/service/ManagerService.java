package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Manager;

public interface ManagerService extends IService<Manager>{
    Manager selectByUsername(String username);

    PageInfo<Manager> selectByPage(Manager manager, int start, int length);

    void delUser(Integer userid);
}
