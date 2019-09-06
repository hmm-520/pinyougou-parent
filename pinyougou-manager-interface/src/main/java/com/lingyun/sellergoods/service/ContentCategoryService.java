package com.lingyun.sellergoods.service;

import com.lingyun.pojo.TbContentCategory;
import entity.PageResult;

import java.util.List;

public interface ContentCategoryService {

    //广告分类列表查询
    public List<TbContentCategory> findAll();
    //新增
    public  void add(TbContentCategory contentCategory);

   //删除
    public void delete(Integer[] ids);

    public TbContentCategory findOne(Integer id);

    public void update (TbContentCategory contentCategory);

    /**
     * 广告分类列表展示
     */
    public PageResult findPage(TbContentCategory contentCategory, int pageSize, int pageNum);

}
