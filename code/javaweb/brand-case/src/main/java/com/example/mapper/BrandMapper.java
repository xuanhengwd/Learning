package com.example.mapper;

import com.example.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {


    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 单个删除
     * @param id
     */
    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);


    void updateById(Brand brand);

}
