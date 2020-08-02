package com.cyf.cloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by cyf
 * @date 2020/8/2.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping(value = "/auth/admin")
    public Object adminAuth(){
        return "has admin auth";
    }
}
