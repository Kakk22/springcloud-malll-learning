package com.cyf.cloud.service.impl;

import com.cyf.cloud.domain.CommonResult;
import com.cyf.cloud.domain.User;
import com.cyf.cloud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by cyf
 * @date 2020/7/29.
 */
@Component
public class UserFallbackService implements UserService {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<List<User>> getByIds(List<Long> ids) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        ArrayList<User> list = new ArrayList<>();
        list.add(defaultUser);
        return new CommonResult<List<User>>(list);
    }
}
