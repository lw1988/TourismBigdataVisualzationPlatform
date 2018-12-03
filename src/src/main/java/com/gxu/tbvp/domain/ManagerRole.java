package com.gxu.tbvp.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "manager_role")
public class ManagerRole implements Serializable {
    private static final long serialVersionUID = 2139792234224938989L;
    @Column(name = "managerId")
    private Integer managerid;

    @Column(name = "roleId")
    private String roleid;

    /**
     * @return managerId
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * @param managerid
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * @return roleId
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}