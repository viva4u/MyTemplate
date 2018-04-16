package com.mytemplate.service.Impl;

import com.mytemplate.mapper.UserBasicMapper.UserBasicMapper;
import com.mytemplate.model.User;
import com.mytemplate.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBasicServiceImpl implements UserBasicService{
    @Autowired
    private UserBasicMapper userBasicMapper;

    public UserBasicMapper getUserBasicMapper() {
        return userBasicMapper;
    }

    public void setUserBasicMapper(UserBasicMapper userBasicMapper) {
        this.userBasicMapper = userBasicMapper;
    }
    @Override
    public User getUser(User user){
        return this.getUserBasicMapper().getUser(user);
    }
    @Override
    public Map<String,Object> pageQuery(Map<String,Object> params){
        HashMap<String,Object> result = new HashMap();
        List<User> users = this.getUserBasicMapper().pageQuery(params);
        if(params.get("username")!=null || params.get("deptment")!=null){
            HashMap<String,Object> total = new HashMap<String, Object>();
            total.put("username",params.get("username"));
            total.put("deptment",params.get("deptment"));
            result.put("total",this.getUserBasicMapper().pageQuery(total).size());
        }else {
            result.put("total",this.getUserBasicMapper().pageQuery(null).size());
        }
        result.put("rows",users);
        return result;
    }
    @Override
    public User checkUser(String name){
        return this.getUserBasicMapper().checkUser(name);
    }
    @Override
    public void newUser(User user){
        this.getUserBasicMapper().newUser(user);
    }
}
