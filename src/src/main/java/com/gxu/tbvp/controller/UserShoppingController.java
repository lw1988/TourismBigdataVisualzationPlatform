package com.gxu.tbvp.controller;

import com.gxu.tbvp.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("userShoppingJson")
public class UserShoppingController {
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 101, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));
    LinkedBlockingQueue<Runnable> queue = (LinkedBlockingQueue<Runnable>) executor.getQueue();

    @Resource
    private UserService userService;

    @RequestMapping("/GetShoppingHabits")
    public ArrayList<Map> getUserAge() throws InterruptedException{
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final String[] agesChi = "10%以下,20%-40%,40%-60%,60%-80%,80%以上".split(",");
        final int[] ages = {10,20,30,40,50,60};

        HashMap<String, int[]> hashMap = new HashMap<String, int[]>();
        for (int i = 0; i < ages.length -1; i++) {
            int[] put = {ages[i], ages[i+1]};
            hashMap.put(agesChi[i], put);
        }

        ArrayList<Map> mapArrayList = new ArrayList<>();
        for(String agec:agesChi){
            Map map = new HashMap();
            int temp =0;
            for (String agec1:agesChi){
                if (agec.contains(agec1)){
                    String drilldown = "a" + temp;
                    map.put("drilldown",drilldown);
                }
                temp ++;
            }

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Map<String, Object> map1 = new HashedMap();
                        map1.put("first",(int)hashMap.get(agec)[0]);
                        map1.put("last",(int)hashMap.get(agec)[1]);
                        map.put("data", agec);
                        map.put("y",userService.countAge(map1));
                        System.out.println(map);
                        mapArrayList.add(map);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        return mapArrayList;
    }
}
