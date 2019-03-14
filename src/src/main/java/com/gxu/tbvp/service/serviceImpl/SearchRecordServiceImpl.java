package com.gxu.tbvp.service.serviceImpl;

import com.gxu.tbvp.domain.SearchRecord;
import com.gxu.tbvp.mapper.SearchRecordMapper;
import com.gxu.tbvp.service.SearchRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SearchRecordServiceImpl extends  BaseService<SearchRecord> implements SearchRecordService {

    @Resource
    private  SearchRecordMapper searchRecordMapper;

    @Override
   public  void insertSearchRecord(String searchProduceTitle, Date createdTime, String userName){
        searchRecordMapper.insertSearchRecord(searchProduceTitle,createdTime,userName);
   }
    @Override
   public  List<Map> getDefaultSearchData(){
       List<String> strList=searchRecordMapper.getDefaultSearchData();
       List<Map> list=new ArrayList<Map>();
        Map<String,Object> mapList;
        for(String str:strList){
            mapList=new HashMap<String,Object>();
            mapList.put("name",str);
            mapList.put("weight",searchRecordMapper.getCountByTitle(str));

            list.add(mapList);

        }
       return   list;
   }
    @Override
   public   List<String> getSearchRecordByUserName(String userName){
       List<String> strList=searchRecordMapper.getSearchRecordByUserName(userName);
       return   strList;
   }
    @Override
    public  List<Map> getSearchRecordByTitle(String title){

        List<String> strList=searchRecordMapper.getSearchRecordByTitle(title);
        Map<String,Object> mapList=new HashMap<String,Object>();
        List<Map> list=new ArrayList<Map>();
        for(String str:strList){
            mapList=new HashMap<String,Object>();
            mapList.put("name",str);
            mapList.put("weight",searchRecordMapper.getCountByTitle(str));
            list.add(mapList);
        }
        return  list;
    }
}
