package xh.app.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DriudDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        System.out.println(System.getProperty("user.dir"));
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接
        Connection conn = dataSource.getConnection();

        System.out.println(conn);


    }
}
