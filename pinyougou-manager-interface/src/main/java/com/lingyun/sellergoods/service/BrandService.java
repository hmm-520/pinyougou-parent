package com.lingyun.sellergoods.service;


import com.lingyun.pojo.Staff;
import com.lingyun.pojo.TBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {


    List<Staff> queryStaffList();

    /**
     * 查品牌分页
     */
    public PageResult findBrand(int pageSize,int pageNum);

    /**
     * 条件查询，分页展示
     */
    public PageResult findBrand(TBrand brand, int pageSize, int pageNum);

    /**
     * 品牌新增
     */
    public void add(TBrand tBrand);
    /**
     * 删除
     */
    public void delete(Integer id);

    /**
     * 批量删除
     */
    public void deleteIds(Integer[] ids);



}
