package com.gxu.tbvp.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.domain.ManagerRole;
import com.gxu.tbvp.service.ManagerRoleService;
import com.gxu.tbvp.service.ManagerService;
import com.gxu.tbvp.utils.PasswordHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @Resource
    private ManagerRoleService managerRoleService;

    @RequestMapping(value="/addManager",method= RequestMethod.GET)
    public String addUser(){
        return "register";
    }

    @RequestMapping(value="/addManager",method=RequestMethod.POST)
    public String addManager(HttpServletRequest request, Manager manager, Model model){
        Manager m = managerService.selectByUsername(manager.getUsername());
        if(m != null)
            return "error";
        try {
            manager.setRole(0);
            manager.setEnable(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(manager);
            manager.setRegisterTime(new Date());
            managerService.save(manager);
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping
    public Map<String,Object> getAll(Manager manager, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Manager> pageInfo = managerService.selectByPage(manager, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    /**
     * 保存用户角色
     * @param managerRole 用户角色
     *  	  此处获取的参数的角色id是以 “,” 分隔的字符串
     * @return
     */
    @RequestMapping("/saveUserRoles")
    public String saveUserRoles(ManagerRole managerRole){
        if(StringUtils.isEmpty(managerRole.getRoleid()))
            return "error";
        try {
            managerRoleService.addUserRole(managerRole);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/add")
    public String add(Manager manager) {
        Manager u = managerService.selectByUsername(manager.getUsername());
        if(u != null)
            return "error";
        try {
            manager.setEnable(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(manager);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date time= df.parse(df.format(new Date()));// new Date()为获取当前系统时间
            manager.setRegisterTime(time);
            managerService.save(manager);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            managerService.delUser(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }


}
