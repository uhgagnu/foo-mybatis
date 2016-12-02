import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sunnyboy.dao.impl.UserDaoImpl;
import cn.sunnyboy.pojo.User;

public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
      //指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件内容
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testQueryUserById() {
        UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
        User user1 = userDaoImpl.queryUserById(1L);
        System.out.println(user1);
    }

    @Test
    public void testQueryAll() {
        UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
        List<User> list = userDaoImpl.queryAllUser();
        for (User user : list) {
            System.out.println(user);
        }
        
    }

    @Test
    public void testSaveUser() {
        UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);

        User user2 =  new User();
        user2.setUserName("laoyang");
        user2.setAge(39);
        user2.setName("mimi");
        user2.setPassword("123456");
        user2.setSex(1);
        userDaoImpl.saveUser(user2);
    }

    @Test
    public void testUpdateUser() {
        UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
        User user2 =  new User();
        user2.setId(9L);
        user2.setUserName("laoyang2");
        user2.setAge(39);
        user2.setName("mmmmm");
        user2.setPassword("123456");
        user2.setSex(2);
        
        userDaoImpl.updateUser(user2);
    }

    @Test
    public void testDeleteUser() {
        UserDaoImpl userDaoImpl = new UserDaoImpl(sqlSessionFactory);
        userDaoImpl.deleteUser(9L);
    }

}
