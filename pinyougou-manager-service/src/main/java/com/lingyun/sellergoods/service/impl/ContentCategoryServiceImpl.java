package com.lingyun.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.mapper.TbContentCategoryMapper;
import com.lingyun.pojo.TbContentCategory;
import com.lingyun.pojo.TbContentCategoryExample;
import com.lingyun.sellergoods.service.ContentCategoryService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired

    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<TbContentCategory> findAll() {
        return contentCategoryMapper.selectByExample(null);
    }

    @Override
    public void add(TbContentCategory contentCategory) {
        contentCategoryMapper.insert(contentCategory);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbContentCategory findOne(Integer id) {
        return contentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbContentCategory contentCategory) {
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
    }

    @Override
    public PageResult findPage(TbContentCategory contentCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        if (contentCategory!=null){
           if (contentCategory.getName() !=null && contentCategory.getName().length()>0){
               criteria.andNameLike("%"+contentCategory.getName()+"%");
           }
        }
        Page<TbContentCategory> page = (Page<TbContentCategory>) contentCategoryMapper.selectByExample(example);
        long totalPage  = (int) Math.ceil(page.getTotal()/ pageSize) + 1;
        return new PageResult(page.getTotal(), page.getResult(), pageNum, pageSize, totalPage);

    }
}
