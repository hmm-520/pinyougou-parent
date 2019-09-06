package com.lingyun.sellergoods.service;

import com.lingyun.pojo.TbContent;
import entity.PageResult;

public interface ContentService {

    /**
     * 广告列表，分页条件查询
     * @return
     */
    public PageResult findPage(TbContent content, int pageNum, int pageSize);

}
