package com.gxu.tbvp.domain;


public class RecomendList {
    private Integer id;

    /**
     * 代理用户名
     */
    private String user;

    private String like1;
    private String like2;
    private String like3;
    private String like4;
    private String like5;
    private String like6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLike1() {
        return like1;
    }

    public void setLike1(String like1) {
        this.like1 = like1;
    }

    public String getLike2() {
        return like2;
    }

    public void setLike2(String like2) {
        this.like2 = like2;
    }

    public String getLike3() {
        return like3;
    }

    public void setLike3(String like3) {
        this.like3 = like3;
    }

    public String getLike4() {
        return like4;
    }

    public void setLike4(String like4) {
        this.like4 = like4;
    }

    public String getLike5() {
        return like5;
    }

    public void setLike5(String like5) {
        this.like5 = like5;
    }

    public String getLike6() {
        return like6;
    }

    public void setLike6(String like6) {
        this.like6 = like6;
    }

    @Override
    public String toString() {
        return "RecomendList{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", like1='" + like1 + '\'' +
                ", like2='" + like2 + '\'' +
                ", like3='" + like3 + '\'' +
                ", like4='" + like4 + '\'' +
                ", like5='" + like5 + '\'' +
                ", like6='" + like6 + '\'' +
                '}';
    }
}
