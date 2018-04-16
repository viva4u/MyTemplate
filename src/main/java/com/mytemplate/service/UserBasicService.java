package com.mytemplate.service;

import com.mytemplate.model.User;

import java.util.Map;

public interface UserBasicService {
    public User getUser(User user);
    public Map<String,Object> pageQuery(Map<String,Object> params);
    public User checkUser(String name);
    public void newUser(User user);
}
