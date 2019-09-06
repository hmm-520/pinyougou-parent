package com.lingyun.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.pojo.TbContent;
import com.lingyun.sellergoods.service.ContentService;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference(timeout = 60000)
     private ContentService contentService;

    @RequestMapping("/search")
    public PageResult search (TbContent Content, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "2")  int rows){
        return contentService.findPage(Content,page,rows);
    }



}
