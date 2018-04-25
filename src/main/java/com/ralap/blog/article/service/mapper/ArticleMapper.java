package com.ralap.blog.article.service.mapper;

import com.ralap.blog.article.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: ralap
 * @date: created at 2018/4/22 11:31
 */
@Mapper
public interface ArticleMapper {

    /**
     * 添加文章
     * @param article
     */
    @Insert("insert into article(article_name,article_ip,sort_article_id,user_id,type_id,article_type,article_content,article_up,article_support,remake,create_time) values(#{articleName},#{articleIp},#{sortArticleId},#{userId},#{typeId},#{articleType},#{articleContent},#{articleUp},#{articleSupport},#{remake},#{createTime})")
    void insertArticle(Article article);

}
