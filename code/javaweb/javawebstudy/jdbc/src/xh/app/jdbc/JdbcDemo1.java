package xh.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {


    public static void main(String[] args) throws Exception {
        int id = 6;
        String name = "tom";
        String passWord="frifcr23";

        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //获取连接

        String url="jdbc:mysql://123.56.129.233/db1?useSSL=false";
        String username="root";
        String password="824320xh@XH";

        Connection conn = DriverManager.getConnection(url, username, password);

        //书写sql语句
        String sql="insert into user(id,name,password) values('"+id+"','"+name+"','"+passWord+"')";

        //获取执行sql对象
        Statement stmt = conn.createStatement();

        //执行sql
        int count = stmt.executeUpdate(sql);
        if(count>0) System.out.println("成功~");
        else System.out.println("失败~");

        stmt.close();
        conn.close();
    }
}
