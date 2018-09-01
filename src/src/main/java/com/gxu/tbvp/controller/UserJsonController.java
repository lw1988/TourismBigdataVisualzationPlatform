package com.gxu.tbvp.controller;

import com.gxu.tbvp.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userJson")
public class UserJsonController {

    @Resource
    private UserService userService;

    @RequestMapping("/getSexJson")
    public Map getSexJson() {
        int countGirl = userService.countSex(1);
        int countBoy = userService.countSex(0);
        System.out.println(countBoy);
        Map sexMap = new HashMap();
        sexMap.put("boy", countBoy);
        sexMap.put("girl", countGirl);
        return sexMap;
    }
}
