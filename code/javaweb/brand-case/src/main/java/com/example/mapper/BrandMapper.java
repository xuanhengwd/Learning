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

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin},#{size};")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand ")
    int selectTotalCount();


    /**
     * 条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数查询总记录数
     * @return
     */

    int selectTotalCountByCondition(Brand brand);


}
