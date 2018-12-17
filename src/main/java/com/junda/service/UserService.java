package com.junda.service;

import com.junda.common.ResultInfo;

public interface UserService {

    ResultInfo listUsers();

    ResultInfo deleteUser(Long userId);

    ResultInfo addUser(String name,String sex,Integer age);

    ResultInfo updateUser(Long userId,String name,String sex,Integer age,Integer status);

    ResultInfo findUser(Long userId);


}
