package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.SearchRecord;
import org.w3c.dom.ls.LSInput;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SearchRecordService extends IService<SearchRecord> {
    //添加搜素记录
    void insertSearchRecord(String searchProduceTitle, Date createdTime, String userName);
    //默认显示前十个搜索记录
    List<Map> getDefaultSearchData();

    List<String> getSearchRecordByUserName(String userName);
    //获取搜索的相关景点
    List<Map> getSearchRecordByTitle(String title);


}
