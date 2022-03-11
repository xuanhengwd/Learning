package xh.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xh.app.mapper.BrandMapper;
import xh.app.pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {


    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void testSelectAll() throws Exception {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 查询详情
     * @throws Exception
     */
    @Test
    public void testSelectById() throws Exception {

        int id =1;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();
    }

    /**
     * 多条件查询
     * @throws Exception
     */
    @Test
    public void testSelectByCondition() throws Exception {

        int status = 0;
        String companyName="松鼠";
        String brandName = "松鼠";

        //处理数据
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 多条件 动态sql
     * @throws Exception
     */
    @Test
    public void testSelectByCondition1() throws Exception {

        int status = 1;
        String companyName="松鼠";
        String brandName = "松鼠";

        //处理数据
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition1(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 动态sql 单个条件查询
     * @throws Exception
     */
    @Test
    public void testSelectByConditionSingle() throws Exception {

        int status = 1;
        String companyName="松鼠";
        String brandName = "松鼠";

        //处理数据
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition1(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 添加数据
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {

        String brandName = "IQOO8 pro";
        String companyName="维沃移动通信有限公司";
        int ordered = 500;
        String description = "核心无畏,生来坚强!";
        int status = 0;

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);


        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        //提交事务
        sqlSession.commit();

        System.out.println(brand.getId());


        sqlSession.close();
    }

    /**
     * 添加数据
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {

        String brandName = "IQOO8 pro";
        String companyName="维沃移动通信有限公司";
        int ordered = 600;
        String description = "核心无畏,生来坚强!";
        int status = 1;
        int id = 5;

        Brand brand = new Brand();
        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
//        brand.setDescription(description);
        brand.setStatus(status);
        brand.setId(id);


        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 删除一行数据
     * @throws Exception
     */
    @Test
    public void testDeleteById() throws Exception {

        int id = 7;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 批量删除
     * @throws Exception
     */
    @Test
    public void testDeleteByIds() throws Exception {

        int[] ids = {6,8,9};

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
