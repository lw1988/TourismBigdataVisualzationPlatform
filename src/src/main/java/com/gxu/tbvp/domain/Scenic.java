package com.gxu.tbvp.domain;


import javax.persistence.*;
import java.io.Serializable;

public class Scenic implements Serializable {

//    @Id
//    private Integer id;
//
//    private String scenic;
//
//    private String province;
//
//    /**
//     * @return id
//     */
//    public Integer getId() {
//        return id;
//    }
//
//    /**
//     * @param id
//     */
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    /**
//     * @return scenic
//     */
//    public String getScenic() {
//        return scenic;
//    }
//
//    /**
//     * @param scenic
//     */
//    public void setScenic(String scenic) {
//        this.scenic = scenic;
//    }
//
//    /**
//     * @return provice
//     */
//    public String getProvince() {
//        return province;
//    }
//
//    /**
//     * @param province
//     */
//    public void setProvince(String province) {
//        this.province = province;
//    }


    @Id
    private Integer id;

    private String title;

    private String description;

    private String city;

    private String level;

    private String place;

    private String price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}