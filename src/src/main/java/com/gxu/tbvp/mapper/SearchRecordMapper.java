package com.gxu.tbvp.mapper;
import com.gxu.tbvp.mockData.ProduceItemBuyRecord;
import com.gxu.tbvp.utils.MyMapper;
import com.gxu.tbvp.domain.SearchRecord;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface SearchRecordMapper extends MyMapper<SearchRecord> {
        //添加搜素记录
        void insertSearchRecord(@Param("searchProduceTitle") String searchProduceTitle,@Param("createdTime") Date createdTime,@Param("userName") String userName);
        //默认显示前十个搜索记录
        List<String> getDefaultSearchData();
        //当用户登录没搜素时先查询历史搜搜记录,没有搜索记录则显示前十个搜索记录
        List<String> getSearchRecordByUserName(@Param("userName") String userName);
        //查询搜索相关的景点
        List<String>  getSearchRecordByTitle(@Param("title") String title);
        //查询某一景点的搜索次数
        Integer getCountByTitle(@Param("searchProduceTitle") String searchProduceTitle);

        }

