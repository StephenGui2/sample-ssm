package com.junda.service;

import com.google.common.base.Strings;
import com.junda.common.ResultEnum;
import com.junda.common.ResultInfo;
import com.junda.domain.DoUser;
import com.junda.model.User;
import com.junda.support.IDUtils;
import com.junda.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResultInfo listUsers() {
        List<User> userList = userDao.getUserList();
        if (userList == null || userList.size() == 0) {
            return new ResultInfo(ResultEnum.EMPTY_USER_LIST.status, ResultEnum.EMPTY_USER_LIST.desc);
        }
        return ResultInfo.createSuccess(userList);
    }

    @Override
    public ResultInfo deleteUser(Long userId) {

        int res = userDao.deleteByUserId(userId);
        return res > 0 ? ResultInfo.createSuccess() : new ResultInfo(ResultEnum.DELETE_NO_CURRENT_USER.status, ResultEnum.DELETE_NO_CURRENT_USER.desc);
    }

    @Override
    public ResultInfo addUser(String name, String sex, Integer age) {

        if (Strings.isNullOrEmpty(name)) {
            return new ResultInfo(ResultEnum.NAME_EMPTY.status, ResultEnum.NAME_EMPTY.desc);
        }
        if (Strings.isNullOrEmpty(sex)) {
            return new ResultInfo(ResultEnum.SEX_EMPTY.status, ResultEnum.SEX_EMPTY.desc);
        }
        if (Objects.isNull(age)) {
            return new ResultInfo(ResultEnum.AGE_EMPTY.status, ResultEnum.AGE_EMPTY.desc);
        }

        User user = new User();
        user.setUserId(IDUtils.getUserId());
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        int res = userDao.add(user);
        return res > 0 ? ResultInfo.createSuccess() : new ResultInfo(ResultEnum.ADD_USER_FAIL.status, ResultEnum.ADD_USER_FAIL.desc);
    }

    @Override
    public ResultInfo updateUser(Long userId, String name, String sex, Integer age, Integer status) {

        if (Strings.isNullOrEmpty(name)) {
            return new ResultInfo(ResultEnum.NAME_EMPTY.status, ResultEnum.NAME_EMPTY.desc);
        }
        if (Strings.isNullOrEmpty(sex)) {
            return new ResultInfo(ResultEnum.SEX_EMPTY.status, ResultEnum.SEX_EMPTY.desc);
        }
        if (Objects.isNull(age)) {
            return new ResultInfo(ResultEnum.AGE_EMPTY.status, ResultEnum.AGE_EMPTY.desc);
        }
        if (Objects.isNull(status)) {
            return new ResultInfo(ResultEnum.SATTUS_EMPTY.status, ResultEnum.SATTUS_EMPTY.desc);
        }

        User user = userDao.findByUserId(userId);

        if (user == null) {
            return new ResultInfo(ResultEnum.UPDATE_NO_CURRENT_USER.status, ResultEnum.UPDATE_NO_CURRENT_USER.desc);
        }
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setStatus(status);
        user.setUpdateTime(new Date());
        int res = userDao.update(user);
        return res > 0 ? ResultInfo.createSuccess() : new ResultInfo(ResultEnum.UPDATE_USER_FAIL.status, ResultEnum.UPDATE_USER_FAIL.desc);
    }

    @Override
    public ResultInfo findUser(Long userId) {
        User user = userDao.findByUserId(userId);
        DoUser domain = new DoUser();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        domain.setUserId(user.getUserId());
        domain.setName(user.getName());
        domain.setAge(user.getAge());
        domain.setSex(user.getSex());
        domain.setStatus(user.getStatus());
        domain.setCreateTime(sdf.format(user.getCreateTime()));
        domain.setUpdateTime(sdf.format(user.getUpdateTime()));
        return user == null ? new ResultInfo(ResultEnum.FIND_USER_ERROR.status, ResultEnum.FIND_USER_ERROR.desc) :
                ResultInfo.createSuccess(domain);

    }

}
