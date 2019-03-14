package com.gxu.tbvp.domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class SearchRecord implements Serializable {
    @Id
    private  Integer id;

    private  String searchProduceTitle;
    private Date createdTime;
    private  String userName;

    public Integer getId() {
        return id;
    }

    public String getSearchProduceTitle() {
        return searchProduceTitle;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSearchProduceTitle(String searchProduceTitle) {
        this.searchProduceTitle = searchProduceTitle;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
