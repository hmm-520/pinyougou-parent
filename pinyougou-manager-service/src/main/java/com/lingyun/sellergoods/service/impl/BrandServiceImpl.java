package com.lingyun.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.mapper.TBrandMapper;
import com.lingyun.pojo.BrandBean;
import com.lingyun.pojo.Staff;
import com.lingyun.pojo.TBrand;
import com.lingyun.pojo.TBrandExample;
import com.lingyun.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout = 60000)
public class  BrandServiceImpl implements BrandService {

    @Autowired
    private TBrandMapper tbrandMapper;


    @Override
    public List<Staff> queryStaffList() {
        return tbrandMapper.queryStaffList();
    }

    /**
     * 查品牌分页
     */
    @Override
    public PageResult findBrand(int pageSize, int pageNum) {
        PageHelper.startPage(pageSize,pageNum);
        Page<TBrand> page=(Page<TBrand>) tbrandMapper.selectByExample(null);
        long totalPage  = (int) Math.ceil(page.getTotal()/ pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum, pageSize, totalPage);
    }

    @Override
    public PageResult findBrand(TBrand brand, int pageSize, int pageNum) {
        PageHelper.startPage(pageSize,pageNum);
        TBrandExample example = new TBrandExample();
        TBrandExample.Criteria criteria = example.createCriteria();
         if (brand!=null){
             if (brand.getTypename() !=null && brand.getTypename().length()>0){
                 criteria.andTypenameLike("%"+brand.getTypename()+"%");
             }
            if (brand.getBrand() !=null && brand.getBrand().length()>0){
                criteria.andBrandLike("%"+brand.getBrand()+"%");
            }
         }
        Page<TBrand> page=(Page<TBrand>) tbrandMapper.selectByExample(example);
        long totalPage  = (int) Math.ceil(page.getTotal()/ pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum, pageSize, totalPage);
    }

    @Override
    public void add(TBrand tBrand) {
        tbrandMapper.insert(tBrand);
    }

    @Override
    public void delete(Integer id) {
        tbrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteIds(Integer[] ids) {
        for (Integer id:ids){
            tbrandMapper.deleteByPrimaryKey(id);

        }
    }


}
