package com.ralap.blog.user.mapper;

import com.ralap.blog.user.entity.BlogUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: ralap
 * @date: created at 2018/4/18 22:16
 */
@Mapper
public interface BlogUserMapper {

    /**
     * 根据用户名获取用户
     */
    @Select("select * from blog_user where user_name=#{userName}")
    BlogUser selectByUserName(String userName) throws Exception;

    /**
     * 获取所有用户
     */
    @Select("selecct * from blog_user")
    List<BlogUser> getAll();
}
