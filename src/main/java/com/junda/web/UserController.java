package com.junda.web;

import com.junda.common.ResultInfo;
import com.junda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ResultInfo resultInfo = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", resultInfo.data);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUsers(@RequestParam String newName,
                               @RequestParam String newSex, @RequestParam Integer newAge) {
        ResultInfo resultInfo = userService.addUser(newName, newSex, newAge);
        return resultInfo;
    }

    @RequestMapping(value = "/find.do", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo findUser(@RequestParam Long userId) {
        ResultInfo resultInfo = userService.findUser(userId);
        return resultInfo;
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo updateUser(@RequestParam Long userId, @RequestParam String newName,
                                 @RequestParam String newSex, @RequestParam Integer newAge, @RequestParam Integer newStatus) {
        ResultInfo resultInfo = userService.updateUser(userId, newName, newSex, newAge, newStatus);
        return resultInfo;
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteUser(@RequestParam Long userId) {
        ResultInfo resultInfo = userService.deleteUser(userId);
        return resultInfo;
    }

}
