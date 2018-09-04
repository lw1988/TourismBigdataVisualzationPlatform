package com.gxu.tbvp.mockData;

import com.gxu.tbvp.domain.Accessrecord;
import com.gxu.tbvp.exception.SelfJSONResult;
import com.gxu.tbvp.service.AccessrecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class MockAccessRecord {
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

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
    public SelfJSONResult mockAccessRecord() throws ParseException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        MockDate mockDate = new MockDate();

        int i = 0;
        for (i = 0; i < 10; i++) {
            List<Accessrecord> accessrecordList = new ArrayList<>();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 50000; j++) {
                            Accessrecord accessrecord = new Accessrecord();
                            accessrecord.setAccessproduceid(getProduceId());
                            accessrecord.setUserid(getUserId());
                            accessrecord.setTotaltime(getTotalTime());
                            try {
                                accessrecord.setAccesstime(mockDate.RondomDate());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            accessrecordList.add(accessrecord);
                        }
                        int temp = accessrecordService.bachInsert(accessrecordList);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println(countDownLatch);
                }
            });

        }
        countDownLatch.await();
        if (i == 10){
            return SelfJSONResult.ok("success");
        }else {
            return SelfJSONResult.errorMsg("插入失败");
        }
    }
}
