package com.lingyun.mapper;

import com.lingyun.pojo.BrandBean;
import com.lingyun.pojo.Staff;
import com.lingyun.pojo.TBrand;
import com.lingyun.pojo.TBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBrandMapper {

    List<Staff> queryStaffList();

    /**
     * 查品牌分页
     */
    List<BrandBean> selectByBrand(int pageSize, int pageNum);

    int countByExample(TBrandExample example);

    int deleteByExample(TBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBrand record);

    int insertSelective(TBrand record);

    List<TBrand> selectByExample(TBrandExample example);

    TBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByExample(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByPrimaryKeySelective(TBrand record);

    int updateByPrimaryKey(TBrand record);
}