package com.gxu.tbvp.controller;

import com.gxu.tbvp.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/userJson")
public class UserJsonController {

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    @Resource
    private UserService userService;

    @RequestMapping("/getSexJson")
    public Map getSexJson() throws InterruptedException {
//        LinkedBlockingQueue queue = (LinkedBlockingQueue) executor.getQueue();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final int[] sexs =  {0,1};
        final String[] bgs = "boy,girl".split(",");

        Map sexBG = new HashMap();
        for (int i = 0; i < 2; i++) {
            sexBG.put(bgs[i], sexs[i]);
        }

        Map sexMap = new HashMap();
        for (String bg:bgs) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        sexMap.put(bg, userService.countSex((int)sexBG.get(bg)));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        return sexMap;
    }
}
