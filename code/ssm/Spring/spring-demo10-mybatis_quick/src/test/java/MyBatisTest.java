import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test1(){

        String resourse ="mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resourse);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();

            System.out.println(users);
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
