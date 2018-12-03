package com.gxu.tbvp.controller;



import com.gxu.tbvp.domain.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by zqw.
 * twodog.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    //管理员登陆
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Manager manager, Model model){
        if (StringUtils.isEmpty(manager.getUsername()) || StringUtils.isEmpty(manager.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(manager.getUsername(),manager.getPassword());
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
    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public String keywords(){
        return "keywords";
    }

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
        return "combine_route/routeScenic";
    }

    //搜索结果分析
    @RequestMapping(value="/searchResult", method = RequestMethod.GET)
    public String searchResult(){
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

}
