package com.cyf.cloud.service;

import com.cyf.cloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by cyf
 * @date 2020/7/30.
 */
@Service
public class UserService implements UserDetailsService {
    private List<User> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>(4);
        userList.add(new User("admin",password,AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("test",password,AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User("kkk",password,AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> list = userList.stream()
                                  .filter(userItem -> userItem.getUsername().equals(username))
                                  .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }else {
            throw new UsernameNotFoundException("用户密码错误");
        }
    }
}
