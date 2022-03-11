package xh.app.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDemo4_PreparedStatement {

    @Test
    public void login() throws Exception {
        String url="jdbc:mysql://123.56.129.233/db1?useSSL=false";
        String username="root";
        String password="824320xh@XH";

        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "tom";
        String passWord = "' or '1' = '1";

        String sql = "select name from user where name=? and password=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1,name);
        pst.setString(2,passWord);

        ResultSet res = pst.executeQuery();

        if(res.next()){
            System.out.println("成功");
        }
        else{
            System.out.println("失败");
        }
    }
}
