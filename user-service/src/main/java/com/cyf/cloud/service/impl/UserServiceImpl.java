package com.cyf.cloud.service.impl;

import com.cyf.cloud.domain.User;
import com.cyf.cloud.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by cyf
 * @date 2020/7/27.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> userList = new ArrayList<>(3);

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> list = userList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
                    userItem.setUsername(user.getUsername());
                    userItem.setPassword(user.getPassword());
                }
        );
    }

    @Override
    public void delete(Long id) {
        User user = getUser(id);
        if (null != user) {
            userList.remove(user);
        }
    }

    @Override
    public User getByUsername(String username) {
        List<User> list = userList.stream().filter(userItem -> userItem.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        List<User> list = userList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            return list;
        }
        return null;
    }

    @PostConstruct
    public void init() {
        userList.add(new User(1L, "cyf", "123"));
        userList.add(new User(2L, "test", "123"));
        userList.add(new User(3L, "test1", "123"));
    }
}
