package com.lingyun.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.mapper.TbContentMapper;
import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentExample;
import com.lingyun.sellergoods.service.ContentService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


@Service(timeout = 60000)
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public PageResult findPage(TbContent content, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
         if (content !=null){
           if(content.getTitle()!=null && content.getTitle().length()>0){
               criteria.andTitleLike("%"+content.getTitle()+"%");
           }
         }

        Page<TbContent> page = (Page<TbContent>) contentMapper.selectByExample(example);
        long totalPage  = (int) Math.ceil(page.getTotal()/ pageSize) + 1;
        return new PageResult(page.getTotal(), page.getResult(), pageNum, pageSize, totalPage);

    }
}
