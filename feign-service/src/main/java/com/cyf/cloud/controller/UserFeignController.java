package com.cyf.cloud.controller;

import com.cyf.cloud.domain.CommonResult;
import com.cyf.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by cyf
 * @date 2020/7/29.
 */
@RestController
@RequestMapping(value = "/userFeign")
public class UserFeignController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public CommonResult get(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping(value ="/getByUsername")
    public CommonResult getByUsername(@RequestParam String username){
        return userService.getByUsername(username);
    }
}
