package com.ralap.blog.article.controller;

import com.ralap.blog.article.entity.Article;
import com.ralap.blog.article.service.ArticleService;
import com.ralap.blog.base.BaseController;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: ralap
 * @date: created at 2018/4/21 19:08
 */
@Slf4j
@Controller
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject editormdPic(
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String trueFileName = file.getOriginalFilename();

        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));

        String fileName = System.currentTimeMillis() + "_" + (int)Math.random() * 100 + suffix;

        String path = "H:\\git\\ralap_blog\\src\\main\\resources\\static\\assets\\image";

        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String WEB_ROOT = "localhost:8888/";
        JSONObject res = new JSONObject();
        res.put("url", targetFile.getAbsolutePath());
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;
    }

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public void saveArticle(Article article, HttpServletRequest request) {
        try {
            article.setArticleIp(getIpAddr(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        article.setSortArticleId(1);
        article.setUserId(1);
        article.setCreateTime(new Date());
        articleService.saveArticle(article);
    }

    public static void main(String[] args) {
        String path = "src/main/resources/static/assets/aaa.txt";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
