package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.utils.MyMapper;

import java.util.List;

public interface ManagerRoleMapper extends MyMapper<ManagerRole> {
    public List<Integer> findUserIdByRoleId(Integer id);

}
