package com.wsy.cloud.oauth.service.Impl;

import com.wsy.cloud.oauth.domain.MemberDetails;
import com.wsy.cloud.oauth.entry.UmsMember;
import com.wsy.cloud.oauth.mapper.UmsMemberMapper;
import com.wsy.cloud.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    private List<User> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("1223456");

        userList = new ArrayList<>();
        userList.add(new User("macro",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("andy",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User("mark",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        System.out.println("  userList   "+   userList);
    }
    //DaoAuthenticationProvider调用
    //UserDetailsChecker.check()
    //additionalAuthenticationChecks
    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember uname = umsMemberMapper.selectByName(username);
        if(uname!=null)
            return new MemberDetails(uname);
        throw new UsernameNotFoundException("用户名或密码错误");
//        System.out.println(uname);
//        List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
//        if (!CollectionUtils.isEmpty(findUserList)) {
//            return findUserList.get(0);
//        } else {
//            throw new UsernameNotFoundException("用户名或密码错误");
//        }
    }
}
