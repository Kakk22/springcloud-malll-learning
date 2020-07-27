package com.cyf.cloud.service;

import com.cyf.cloud.domain.User;

import java.util.List;

/**
 * @author by cyf
 * @date 2020/7/27.
 */
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
