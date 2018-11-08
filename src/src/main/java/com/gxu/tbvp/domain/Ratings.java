package com.gxu.tbvp.domain;

import java.util.Date;
import javax.persistence.*;

public class Ratings {
    @Id
    private Integer id;

    private Integer userid;

    private Integer scenicid;

    private Integer rating;

    private Date time;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return scenicid
     */
    public Integer getScenicid() {
        return scenicid;
    }

    /**
     * @param scenicid
     */
    public void setScenicid(Integer scenicid) {
        this.scenicid = scenicid;
    }

    /**
     * @return rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}