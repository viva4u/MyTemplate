package com.mytemplate.controller;

import com.mytemplate.model.Category;
import com.mytemplate.model.User;
import com.mytemplate.service.CategoryBasicService;
import com.mytemplate.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private UserBasicService userBasicService;
    @Autowired
    private CategoryBasicService categoryBasicService;
    @RequestMapping("/")
    public String mainPage(){return "home";}
    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public ModelAndView login(User user){
//        System.out.println("#########2222########");
////        return "loginSuccess";
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        User result = userBasicService.getUser(user);
//        System.out.println(result);
//        ModelAndView mav = new ModelAndView();
//        if(result!=null){
//            mav.setViewName("loginSuccess");
//            return mav;
//        }else {
////            model.addAttribute("msg","用户名或密码错误！");
//            mav.setViewName("main");
//            return mav;
//        }
//    }
    public String login(User user){
        System.out.println("#########2222########");
//        return "loginSuccess";
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        User result = userBasicService.getUser(user);
        System.out.println(result);
        if(result!=null){
            return "users";
        }else {
//            model.addAttribute("msg","用户名或密码错误！");
            return "main";
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkUser(String name){
        System.out.println("#########1111########");
        HashMap resultMap = new HashMap();
        User result = userBasicService.checkUser(name);
        if (result!=null){
            resultMap.put("flag",true);
        }else resultMap.put("flag",false);
        return resultMap;
    }
    @RequestMapping(value = "/users")
    @ResponseBody
    public Map<String,Object> Users(Integer pageSize, Integer pageNumber, String username, String deptment){
        HashMap<String,Object> params = new HashMap<>();
        params.put("pageSize",pageSize);
        params.put("pageNumber",(pageNumber-1)*pageSize);
        params.put("username", username);
        params.put("deptment",deptment);
        System.out.println(params.get("deptment"));
        return userBasicService.pageQuery(params);
    }
//    @RequestMapping(value = "/newUser")
    public void newUser(User user){
        userBasicService.newUser(user);
    }
    public void newCate(Category category) throws Exception{
        categoryBasicService.addCategory(category);
    }
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/register")
    public String add(@ModelAttribute("user") User user, @ModelAttribute("category") Category category) throws Exception{
//        try {
            this.newUser(user);
            this.newCate(category);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            throw e;
//        }
        return "forward:/login";
    }
    @InitBinder("category")
    public void initCateBinder(WebDataBinder binder){
        binder.setFieldDefaultPrefix("Category.");
    }
    @InitBinder("user")
    public void initUserBinder(WebDataBinder binder){
        binder.setFieldDefaultPrefix("User.");
    }
    @RequestMapping(value = "/testNav")
    public String testNav(){
        return "testNav";
    }
}
