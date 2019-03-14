package com.gxu.tbvp.service;

import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Produce;

import java.util.List;
import java.util.Map;

public interface BuyrecordService extends IService<Buyrecord> {
    int insertList(List<Buyrecord> buyrecordList);

    List<Produce> selectAllProducePrice();

    double selectProducePrice(int produceId);

    int updatePrice(List<Produce> produceList);

    int countPeopleByPrice(Map<String, Object> map);

    int countSaleByTime(int month,int year);

    int countVisitsByTime(int month,int year);

    int countHolidaySale(int store,int holiday,int year);

    int countHolidayCustomers(int store,int holiday,int year);

    int countPromoSale(int promo,int month,int year);

    int countPromoCustomers(int promo,int month,int year);

    int getSaleWay(int storetype,int month,int year);

    List<Buyrecord> selectByscenicId(int scenicId);

    List<Buyrecord> getUserScenicBuyrecord(int id, int userId);

    PageInfo<Buyrecord> selectByPage(Buyrecord buyrecord, int start, int length);


}
