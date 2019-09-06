package com.lingyun.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.pojo.TbContentCategory;
import com.lingyun.sellergoods.service.ContentCategoryService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

  @Reference(timeout = 60000)
 private ContentCategoryService contentCategoryServicet;

    @RequestMapping("/findAll")
  public List<TbContentCategory>findAll(){
        return contentCategoryServicet.findAll();
    }
    //回显
    @RequestMapping("/findOne")
    public TbContentCategory findOne(Integer id){
        return  contentCategoryServicet.findOne(id);
    }


    @RequestMapping("/add")
  public Result add(TbContentCategory contentCategory){
        try {
            if (contentCategory.getId()!=null){
                contentCategoryServicet.update(contentCategory);
            }
            else{
                contentCategoryServicet.add(contentCategory);
            }

            return  new Result(true,"新增成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new Result(false,"新增失败");
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){

        try {
            contentCategoryServicet.delete(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "删除失败！");
    }

    @RequestMapping("/search")

   public PageResult search (TbContentCategory contentCategory, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int rows){
    return contentCategoryServicet.findPage(contentCategory,page,rows);
    }

}
