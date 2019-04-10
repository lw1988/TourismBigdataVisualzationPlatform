package com.gxu.tbvp.mockData;

import java.io.Serializable;

public class ProduceItemBuyRecord implements Serializable {
    public Integer getProduceId() {
        return produceId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCount() {
        return count;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    //景点id
    private  Integer produceId;
    //景点名称
    private  String title;
    //购买人数
    private  Integer count;
}
