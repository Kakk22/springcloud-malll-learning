package com.cyf.cloud.controller;

import com.cyf.cloud.domain.CommonResult;
import com.cyf.cloud.domain.User;
import com.cyf.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by cyf
 * @date 2020/7/27.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        return new CommonResult("ok", 200);
    }

    @GetMapping(value = "/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        LOGGER.info("根据用户id获取用户信息，用户名称为：{}" + user.getUsername());
        return new CommonResult<>(user);
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody User user) {
        userService.update(user);
        return new CommonResult("ok", 200);
    }

    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        userService.delete(id);
        return new CommonResult("ok", 200);
    }

    @GetMapping(value = "/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username){
        User user = userService.getByUsername(username);
        return new CommonResult<>(user);
    }

    @GetMapping(value = "/getByIds")
    public CommonResult<List<User>> getByIds(@RequestParam List<Long> ids){
        List<User> users = userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}"+users);
        return new CommonResult<>(users);
    }
}
