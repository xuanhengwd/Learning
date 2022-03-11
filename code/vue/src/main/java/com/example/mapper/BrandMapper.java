package com.example.mapper;

import com.example.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

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
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改
     * @param brand
     */
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);

}
