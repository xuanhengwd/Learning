package xh.app.mapper;

import org.apache.ibatis.annotations.Param;
import xh.app.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    /**
     * 查看详情
     *
     */
    Brand selectById(int id);

    /**
     * 多条件查询
     */

    //方法一使用 `@Param("参数名称")` 标记每一个参数
    //List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName, @Param("brandName") String brandName);

    //方法二多个参数封装成一个 实体对象 。
    //List<Brand> selectByCondition(Brand brand);

    //方法三 map
    List<Brand> selectByCondition(Map map);

    /**
     * 动态sql 多条件查询
     */
    List<Brand> selectByCondition1(Brand brand);

    /**
     * 单个条件查询，动态sql
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除一行
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);



}
