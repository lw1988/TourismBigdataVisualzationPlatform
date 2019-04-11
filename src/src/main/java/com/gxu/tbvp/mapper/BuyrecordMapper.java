package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BuyrecordMapper extends MyMapper<Buyrecord> {
    int countPeopleByPrice(Map<String, Object> map);
    int countSaleByTime(@Param("month") int month, @Param("year") int year);
    int countVisitsByTime(@Param("month") int month, @Param("year") int year);
    List<Buyrecord> getUserScenicBuyrecord(@Param("id") int id, @Param("userId") int userId);
    int countHolidaySale(@Param("store") int store,@Param("holiday")int holiday,@Param("year")int year);
    int countHolidayCustomers(@Param("store") int store,@Param("holiday")int promo,@Param("year")int year);

    int countPromoCustomers(@Param("promo") int promo,@Param("month")int month,@Param("year")int year);
    int countPromoSale(@Param("promo") int promo,@Param("month")int month,@Param("year")int year);
    int getSaleWay(@Param("storetype") int storetype,@Param("month")int month,@Param("year")int year);
//    List<Buyrecord>getPropertyById(int id);

}