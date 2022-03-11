package xh.app.jdbctest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    public static void main(String[] args) throws Exception {

        String url="jdbc:mysql://123.56.129.233/db1?useSSL=false";
        String username="root";
        String password="824320xh@XH";

        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select id, name, money from account";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> accounts = new ArrayList<>();

        Account account = null;
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            account= new Account();
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            accounts.add(account);
        }

        System.out.println(accounts);


    }
}
