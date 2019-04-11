package com.gxu.tbvp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.domain.Produce;
import com.gxu.tbvp.mapper.BuyrecordMapper;
import com.gxu.tbvp.mapper.ProduceMapper;
import com.gxu.tbvp.service.BuyrecordService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class BuyrecordServiceImpl extends BaseService<Buyrecord> implements BuyrecordService {

    @Resource
    private BuyrecordMapper buyrecordMapper;

    @Resource
    private ProduceMapper produceMapper;

    @Override
    public int insertList(List<Buyrecord> buyrecordList) {
        try {
            buyrecordMapper.insertList(buyrecordList);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Produce> selectAllProducePrice() {
        List<Produce> produceList = produceMapper.selectAll();
        return produceList;
    }

    @Override
    public double selectProducePrice(int produceId) {
        double price = produceMapper.selectProducePrice(produceId);
        return price;
    }

    @Override
    public  int updatePrice(List<Produce> produceList) {
        try {
            for (Produce produce:produceList) {
                produceMapper.updateByPrimaryKeySelective(produce);
            }
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int countPeopleByPrice(Map<String, Object> map) {
        int temp = buyrecordMapper.countPeopleByPrice(map);
        return temp;
    }

    @Override
    public int countVisitsByTime(int month,int year) {
        Random random = new Random();
        int Visits = buyrecordMapper.countVisitsByTime(month,year)+random.nextInt(1000);
        return Visits;
    }


    @Override
    public int countSaleByTime(int month,int year) {
        int Sale = buyrecordMapper.countSaleByTime(month,year);
        return Sale;
    }
    @Override
    public int countPromoCustomers(int promo, int month,int year) {
        int Customers = buyrecordMapper.countPromoCustomers(promo,month,year);
        return Customers;
    }
    @Override
    public int countPromoSale(int promo, int month,int year) {
        int Sale = buyrecordMapper.countPromoSale(promo,month,year);
        return Sale;
    }

    @Override
    public int countHolidaySale(int store,int holiday,int year){
        int AVESale = buyrecordMapper.countHolidaySale(store,holiday,year)/2;
        return AVESale;
    }

    @Override
    public int countHolidayCustomers(int store,int holiday,int year){
        int AVECustomers = buyrecordMapper.countHolidayCustomers(store,holiday,year)/2;
        return AVECustomers;
    }

    @Override
    public int getSaleWay(int storetype,int month,int year){
        int saleWay = buyrecordMapper.getSaleWay(storetype,month,year);
        return saleWay;
    }


    @Override
    public List<Buyrecord> selectByscenicId(int scenicId) {
        Example example = new Example(Buyrecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("buyproduceid", scenicId);
        List<Buyrecord> buyrecordList = buyrecordMapper.selectByExample(example);
        return buyrecordList;
    }

    @Override
    public List<Buyrecord> getUserScenicBuyrecord(int id, int userId) {
        try {
            List<Buyrecord> buyrecordList = buyrecordMapper.getUserScenicBuyrecord(id, userId);
            return buyrecordList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageInfo<Buyrecord> selectByPage(Buyrecord buyrecord, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Buyrecord.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Buyrecord> buyrecordList = selectByExample(example);
        return new PageInfo<>(buyrecordList);
    }

//    @Override
//    public List<Buyrecord> getPropertyById(int id) {
//        try {
//            List<Buyrecord> buyrecordList = buyrecordMapper.getPropertyById(id);
//            return buyrecordList;
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
