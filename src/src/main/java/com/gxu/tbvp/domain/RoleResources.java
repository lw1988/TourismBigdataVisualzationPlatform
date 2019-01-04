package com.gxu.tbvp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role_resources")
public class RoleResources implements Serializable {
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Id
    @Column(name = "resourcesId")
    private String resourcesid;

    public RoleResources(Integer i, String s) {
        this.roleid = i;
        this.resourcesid = s;
    }

    public RoleResources(){

    }

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return resourcesId
     */
    public String getResourcesid() {
        return resourcesid;
    }

    /**
     * @param resourcesid
     */
    public void setResourcesid(String resourcesid) {
        this.resourcesid = resourcesid;
    }
}