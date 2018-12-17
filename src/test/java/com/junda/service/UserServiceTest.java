package com.junda.service;

import com.junda.common.ResultInfo;
import com.junda.support.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
    @Autowired
    public UserService userService;

    @Test
    public void getUserListTest() {
        ResultInfo resultInfo = userService.listUsers();
        Assert.assertEquals(resultInfo.status, 0);
        LOG.info("json userList: {}", JsonUtil.obj2String(resultInfo.data));
    }

    @Test
    public void delteUserTest() {
        ResultInfo resultInfo = userService.deleteUser(154485323266004L);
        Assert.assertEquals(resultInfo.status, 0);
    }

    @Test
    public void addUser() {
        ResultInfo resultInfo = userService.addUser("lixiang", "女", 23);
        Assert.assertEquals(resultInfo.status, 0);
    }

    @Test
    public void updateUser() {
        ResultInfo resultInfo = userService.updateUser(154485323263853L, "junda", "man", 22, 0);
        Assert.assertEquals(resultInfo.status, 0);
    }
}
