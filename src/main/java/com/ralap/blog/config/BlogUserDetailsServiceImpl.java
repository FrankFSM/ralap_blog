package com.ralap.blog.config;

import com.ralap.blog.user.entity.BlogUser;
import com.ralap.blog.user.mapper.BlogUserMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * 用户详情实现
 *
 * @author: ralap
 * @date: created at 2018/4/18 21:59
 */
@Service
public class BlogUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BlogUserMapper blogUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BlogUser user = null;
        UserDetails userDetails = null;
        try {
            user = blogUserMapper.selectByUserName(s);
            if (user == null) {
                throw new UsernameNotFoundException("用户不存在");
            }
            userDetails = new User(user.getUserName(), user.getUserPwd(),
                    createAuthority(user.getUserPower()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    private List<SimpleGrantedAuthority> createAuthority(String roles) {
        if (StringUtils.isEmpty(roles)) {
            return null;
        }
        String[] rolesStr = roles.split(",");
        List<SimpleGrantedAuthority> authoritieList = new ArrayList<>();
        SimpleGrantedAuthority authority;
        for (String role : rolesStr) {
            authority = new SimpleGrantedAuthority(role);
            authoritieList.add(authority);
        }
        return authoritieList;
    }
}
