package com.ralap.blog.article.service;

import com.ralap.blog.article.entity.Article;

/**
 * @author: ralap
 * @date: created at 2018/4/22 11:27
 */

public interface ArticleService {

    /**
     * 保存文章
     * @param article 文章
     */
    void saveArticle(Article article);
}
