package com.gxu.tbvp.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProduceMonthSold {
    /**
     * 购买的产品id
     */
    @Id
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;
    /**
     * 购买的数量count
     */
    @Column(name = "total")
    private Integer total;

    @Column(name = "proportion")
    private Float proportion;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Float getProportion() {
        return proportion;
    }

    public void setProportion(Float proportion) {
        this.proportion = proportion;
    }
}
