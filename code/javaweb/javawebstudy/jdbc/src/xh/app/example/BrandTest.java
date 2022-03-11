package xh.app.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import xh.app.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {


    /**
     *查询所有商品
     */
    @Test
    public void testSelectAll() throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet res = pstmt.executeQuery();

        //封装成brand对象
        List<Brand> brands = new ArrayList<>();
        Brand brand = null;
        while (res.next()){
            int id = res.getInt("id");
            String brandName = res.getString("brand_name");
            String companyName = res.getString("company_name");
            int ordered = res.getInt("ordered");
            String description = res.getString("description");
            int status = res.getInt("status");
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);

        }

        System.out.println(brands);
        res.close();
        pstmt.close();
        conn.close();


    }

    /**
     * 添加数据
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        int count = pstmt.executeUpdate();
        if(count>0){
            System.out.println("添加成功~");
        }
        else {
            System.out.println("添加失败~");
        }
        pstmt.close();
        conn.close();
    }

    /**
     * 修改信息
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1100;
        String description = "绕地球一圈";
        int status = 1;
        int id = 4;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        int count = pstmt.executeUpdate();
        if(count>0){
            System.out.println("修改成功~");
        }
        else {
            System.out.println("修改失败~");
        }
        pstmt.close();
        conn.close();
    }

    /**
     * 删除信息
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        int id = 4;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "delete from tb_brand where id =?";


        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);

        int count = pstmt.executeUpdate();
        if(count>0){
            System.out.println("删除成功~");
        }
        else {
            System.out.println("删除失败~");
        }
        pstmt.close();
        conn.close();
    }

}
