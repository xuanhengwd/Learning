package com.example.service;

import com.example.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
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
    void deleteByIds(int[] ids);

    /**
     * 单个删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 修改
     * @param brand
     */
    void updateById(Brand brand);
}
