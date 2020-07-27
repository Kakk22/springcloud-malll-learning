package com.cyf.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by cyf
 * @date 2020/7/27.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

}
