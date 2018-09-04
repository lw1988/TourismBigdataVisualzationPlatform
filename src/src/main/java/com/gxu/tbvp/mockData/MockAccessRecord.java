package com.gxu.tbvp.mockData;

import com.gxu.tbvp.domain.Accessrecord;
import com.gxu.tbvp.exception.SelfJSONResult;
import com.gxu.tbvp.service.AccessrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MockAccessRecord {

    @Resource
    private AccessrecordService accessrecordService;

    public static int getNum(int start, int end) {
        return (int)(Math.random()*(end - start +1)+start);
    }

    //返回浏览次数
    public static int getTotalTime(){
        return getNum(1, 10);
    }

    //return 浏览的产品id
    public static int getProduceId() {
        return getNum(1, 1000);
    }

    //return 用户id
    public static int getUserId() {
        return getNum(0, 751010);
    }

    @RequestMapping("/mockAccessRecord")
    public SelfJSONResult mockAccessRecord() throws ParseException {
        MockDate mockDate = new MockDate();
        List<Accessrecord> accessrecordList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Accessrecord accessrecord = new Accessrecord();
            accessrecord.setAccessproduceid(getProduceId());
            accessrecord.setUserid(getUserId());
            accessrecord.setTotaltime(getTotalTime());
            accessrecord.setAccesstime(mockDate.RondomDate());

            accessrecordList.add(accessrecord);
        }
        int temp = accessrecordService.bachInsert(accessrecordList);
        if (temp == 1){
            return SelfJSONResult.ok(accessrecordList.get(0));
        }else {
            return SelfJSONResult.errorMsg("插入失败");
        }
    }
}
