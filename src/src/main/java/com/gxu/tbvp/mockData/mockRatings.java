package com.gxu.tbvp.mockData;

import com.gxu.tbvp.domain.Ratings;
import com.gxu.tbvp.domain.User;
import com.gxu.tbvp.exception.SelfJSONResult;
import com.gxu.tbvp.service.UserService;
import com.gxu.tbvp.utils.PasswordHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class mockRatings {
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize + 1, 101, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));
    LinkedBlockingQueue<Runnable> queue = (LinkedBlockingQueue<Runnable>) executor.getQueue();

    @Resource
    private UserService userService;

    //随机生成start-end之间的数
    public static int getNum(int start, int end) {
        return (int)(Math.random()*(end - start +1)+start);
    }
    public static double getDoubleNum(int start, int end) {
        double f = (double)(Math.random()*(end - start +1)+start);
        BigDecimal b = new BigDecimal(f);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //生成用户对景点的评分数据，每个用户至少有20个评分
    @RequestMapping("/mockRatings")
    public SelfJSONResult mockRatings() throws ParseException, InterruptedException {
        MockDate mockDate = new MockDate();
        //设置线程数量
        for (int j = 0; j < 100000; j++) {
            List<Ratings> ratingsList = new ArrayList<>();
            for (int i = 0; i<getNum(5, 10) ; i++){
                Ratings ratings = new Ratings();
                ratings.setScenicid(getNum(0,3219));
                ratings.setUserid(j);
                ratings.setRating(getNum(0,5));
                ratings.setTime(mockDate.RondomDate());
                ratingsList.add(ratings);
            }
            userService.insertBachRatings(ratingsList);
        }
        return SelfJSONResult.ok("success!");
    }



}
