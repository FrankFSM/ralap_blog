package com.ralap.blog.article.service.impl;

import com.ralap.blog.article.entity.Article;
import com.ralap.blog.article.service.ArticleService;
import com.ralap.blog.article.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ralapsss
 * @date: created at 2018/4/22 11:28
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void saveArticle(Article article) {
        articleMapper.insertArticle(article);
    }
}
