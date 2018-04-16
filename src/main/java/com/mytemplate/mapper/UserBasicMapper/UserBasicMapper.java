package com.mytemplate.mapper.UserBasicMapper;

import com.mytemplate.model.User;

import java.util.List;
import java.util.Map;

public interface UserBasicMapper {
    public User getUser(User user);
    public List<User> pageQuery(Map params);
    public User checkUser(String name);
    public void newUser(User user);
}
