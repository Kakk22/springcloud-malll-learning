package com.cyf.cloud.service;

import com.cyf.cloud.domain.CommonResult;
import com.cyf.cloud.domain.User;
import com.cyf.cloud.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by cyf
 * @date 2020/7/29.
 */
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping(value = "/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping(value = "/user/{id}")
    CommonResult<User> getUser(@PathVariable(value = "id") Long id);

    @PostMapping(value = "/update")
    CommonResult update(@RequestBody User user);

    @PostMapping(value = "/delete/{id}")
    CommonResult delete(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/getByUsername")
    CommonResult<User> getByUsername(@RequestParam(value = "username") String username);

    @GetMapping(value = "/getByIds")
    CommonResult<List<User>> getByIds(@RequestParam(value = "ids") List<Long> ids);
}
