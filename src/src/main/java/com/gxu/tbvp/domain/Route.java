package com.gxu.tbvp.domain;


import javax.persistence.Id;
import java.io.Serializable;

public class Route implements Serializable {

    @Id
    private Integer produceid;

    private String title;

    private String description;

    private String price;

    /**
     * @return produceid
     */
    public Integer getId() {
        return produceid;
    }

    /**
     * @param produceid
     */
    public void setId(Integer produceid) {
        this.produceid = produceid;
    }

    /**
     * @return title
     */
    public String getRoute() {
        return title;
    }

    /**
     * @param title
     */
    public void setRoute(String title) {
        this.title = title;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}