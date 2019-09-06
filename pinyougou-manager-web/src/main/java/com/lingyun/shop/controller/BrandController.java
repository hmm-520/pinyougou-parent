package com.lingyun.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.pojo.Staff;
import com.lingyun.pojo.TBrand;
import com.lingyun.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(timeout = 60000)
    private BrandService brandService;

   @RequestMapping("/queryStaffList")
  public  List<Staff> queryStaffList(){
     return  brandService.queryStaffList();
  }

    /**
     * 品牌表分页
     */
    @RequestMapping("/queryBrandList")
    public PageResult queryBrandList(TBrand brand,int page, int rows){
    return brandService.findBrand(brand,page,rows);
    }

    /**
     * 新增品牌
     * @param brand
     */
    @RequestMapping("/addBrand")
    public Result addBrand(TBrand brand){
        try {
            brandService.add(brand);
            return new Result(true, "新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return  new Result(false, "新增失败！");
    }

    //单删
    @RequestMapping("/deleteBrand")
    public Result deleteBrand(Integer id){

        try {
            brandService.delete(id);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"删除失败！");
    }

    //多删
    @RequestMapping("/deleteBrandIds")
    public Result deleteBrandIds(Integer[] id){

        try {
            brandService.deleteIds(id);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"删除失败！");
    }


}
