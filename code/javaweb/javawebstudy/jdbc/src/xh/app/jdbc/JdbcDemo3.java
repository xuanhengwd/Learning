package xh.app.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDemo3 {

    @Test
    public void testLogin() throws Exception {
        String url="jdbc:mysql://123.56.129.233/db1?useSSL=false";
        String username="root";
        String password="824320xh@XH";

        Connection conn = DriverManager.getConnection(url, username, password);


        String name = "tom";
        String passWord = "' or '1' = '1";

        String sql = "select name from user where name='"+name+"' and password='"+passWord+"'";

        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        if(res.next()){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }


        res.close();
        stmt.close();
        conn.close();
    }
}
