package xh.app.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDemo2 {

    @Test
    public void testDQL() throws Exception {

        String url = "jdbc:mysql://123.56.129.233/db1?useSSL=false";
        String username="root";
        String password="824320xh@XH";
        //创建连接
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select id, name, password from user";

        //执行sql对象
        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery(sql);
        while(res.next()){
            int id = res.getInt(1);
            String userName = res.getString("name");
            String passWord = res.getString(3);
            System.out.println(id+" "+userName+" "+passWord);
        }


    }
}
