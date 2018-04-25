package com.ralap.blog.article.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ralap
 * @date: created at 2018/4/22 11:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    /**
     * 主键
     */
    private Integer articleId;
    /**
     * 文章名称
     */
    private String articleName;
    /**
     * 发布时间
     */
    private Data articleTime;
    /**
     * 发布IP
     */
    private String articleIp;
    /**
     * 查看人数
     */
    private Long articleClick;
    /**
     * 所属分类
     */
    private Integer sortArticleId;
    /**
     * 所属用户ID
     */
    private Integer userId;
    /**
     * 栏目ID
     */
    private Integer typeId;
    /**
     * 文章的模式:0为私有，1为公开，2为仅好友查看
     */
    private Long articleType;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 是否置顶:0为否，1为是
     */
    private Integer articleUp;
    /**
     * 是否博主推荐:0为否，1为是
     */
    private Integer articleSupport;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updataTime;


}
