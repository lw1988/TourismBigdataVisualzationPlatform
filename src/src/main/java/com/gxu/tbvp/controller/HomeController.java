package com.gxu.tbvp.controller;



import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.util.StringUtil;
import com.gxu.tbvp.domain.*;
import com.gxu.tbvp.service.*;
import com.gxu.tbvp.service.serviceImpl.RecomendListServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by zqw.
 * twodog.
 */
@Controller
public class HomeController {
    @Resource
    RecomendListService recomendListService;
    @Resource
    ScenicService scenicService;
    @Resource
    BuyrecordService buyrecordService;

    String managerName;

//    @Autowired
//    private RecomendListServiceImpl recomendListService;


    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/managers/addManager",method= RequestMethod.GET)
    public String addUser(){
        return "register";
    }

    //用户登陆
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Manager manager, Model model){

        managerName=manager.getUsername();
        if (StringUtils.isEmpty(manager.getUsername()) || StringUtils.isEmpty(manager.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");

            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(manager.getUsername(),manager.getPassword());
        request.getSession().setAttribute("Username",manager.getUsername());
        try {
            subject.login(token);
            return "redirect:managersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }




    //大数据平台首页
    @RequestMapping(value={"/managersPage",""})
    public String managersPage(){
        return "manager/managers";
    }

    //更多信息（多个列表）
    @RequestMapping(value={"/list"})
    public String list(){
        return "list";
    }

    //更多信息（单个列表）
    @RequestMapping(value={"/morelist"})
    public String morelist(){
        return "morelist";
    }

    //关键词分析
//    @RequestMapping(value="/keywords", method = RequestMethod.GET)
//    public ModelAndView keywords(){
//
//    //        String sql = "select * from items";
////        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        ModelAndView mav = new ModelAndView("keywords");
//        List<ScenicBuyrecord> scenicBuyrecordList = scenicBuyrecordService.selectByscenicId(1);
//        mav.addObject("list", scenicBuyrecordList);
//        System.out.println(scenicBuyrecordList);
//        //mav.addAttribute("data","123456");
//        return mav;
//    }
    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public String  keywords( Model model) {
//        Principal principal  = request.getUserPrincipal();
        List<RecomendList> List = recomendListService.recommendByUser(managerName);
        //Manager manager1=principal.getName();
//        System.out.println("=================================================="+managerName);
//        System.out.println("=================================================="+List.get(0));
        model.addAttribute("data",List.get(0));
        return "keywords";

    }



//    @RequestMapping(value="/keywords", method = RequestMethod.GET)
//    public String keywords(){ return "keywords";}


    //组合路线推荐
    @RequestMapping("/allroutes")
    public String allRoutes(){
        return "combine_route/allroutes";
    }

    //最赚钱路线组合
    @RequestMapping(value="/mostmoneyroutes", method = RequestMethod.GET)
    public String mostMoneyRoutes(){
        return "combine_route/mostmoneyroutes";
    }

    //组合路线推荐内景点分析
    @RequestMapping("/routeScenic")
    public String routeScenic(){
       /* return "combine_route/routeScenic";*/
        return "holidayRoutes";

    }

    //搜索结果分析
    @RequestMapping(value="/searchResult", method = RequestMethod.GET)
    public String searchResult(Model model){
        String city = managerName;
        //System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+city);
        List<Scenic> list = scenicService.getProduceByCity("南宁");
        model.addAttribute("data",list);


//        int i;
//        int count=0;
//
//        for(i=0;i<list.size();i++){
//            int id = list.get(i).getId();
//            List<Buyrecord> list_buyrecord = buyrecordService.getPropertyById(id);
//            for(int j=0;j<list_buyrecord.size();j++){
//                count = list_buyrecord.get(j).getBuytool();
//            }
//
//        }






        //System.out.println("#######################################################"+list.get(0));
        return "searchResult";
    }

    //用户大数据
    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public String visitors(){
        return "user/visitors";
    }

    //产品大数据
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products() {
        return "product/products";
    }

    //代理大数据
    @RequestMapping(value = "/agent", method = RequestMethod.GET)
    public String agent() { return "agent"; }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "resources/resources";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }

    //旅游指数
    @RequestMapping(value="/tourismIndex", method = RequestMethod.GET)
    public String zhishu(){
        return "tourismIndex";

    }




    /*-----管理界面-----*/
    //管理员登录
    @RequestMapping("/adminLogin")
    public String adminLogin(){
        return "admin/adminLogin";
    }

    //用户登陆
    @RequestMapping(value="/adminLogin",method=RequestMethod.POST)
    public String adminLogin(HttpServletRequest request, Manager manager, Model model){
        if (StringUtils.isEmpty(manager.getUsername()) || StringUtils.isEmpty(manager.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(manager.getUsername(),manager.getPassword());
        try {
            subject.login(token);
            return "redirect:managersManagement";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "admin/adminLogin";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "admin/adminLogin";
        }
    }

//    @RequestMapping("/recomend_list")
//    @ResponseBody
//    public Object  itemsList() {
//        Example example = new Example(RecomendList.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("user", "1234");
//        return recomendListService.selectByExample(example);
//    }

//    @RequestMapping("/recomend_list")
//    public String  itemsList(Model model) {
//        model.addAttribute("data","123456");
//        return "aaa/bbb";
//    }




    //景点管理
    @RequestMapping("/scenicsManagement")
    public String scenicsManagement(){
        return "admin/scenic";
    }
    //管理员操作管理
    @RequestMapping("/resourcesManagement")
    public String resourcesManagement(){
        return "admin/resources";
    }
    //管理员管理
    @RequestMapping("/managersManagement")
    public String managersManagement(){
        return "admin/managers";
    }
    //角色管理
    @RequestMapping(value = "/rolesManagement",method = RequestMethod.GET)
    public String rolesManagement(){
        return "admin/roles";
    }


    //模型评估效果
    @RequestMapping(value={"/important"})
    public String important(){
        return "important";
    }

    //路线管理
    @RequestMapping("/routeManagement")
    public String routeManagement(){
        return "admin/route";
    }

}
