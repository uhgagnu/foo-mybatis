package cn.sunnyboy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.sunnyboy.pojo.User;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		//指定mybatis全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "zidingyi");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//操作数据库
		//查询
		Map<String, String>map = sqlSession.selectOne("mybatis-demo.queryUserById", 1L);
		System.out.println(map);
		
//		List<User> listUsers = sqlSession.selectList("mybatis-demo.queryAllUser");
//		for(User user : listUsers){
//			System.out.println("id:"+user.getId());
//		}
		
		//修改
//		User user = new User();
//		user.setId(5L);
//		user.setName("ssssssssss");
//		//sqlSession.update("mybatis-demo.updateUser", user);
//		sqlSession.update("mybatis-demo.updateUser2", user);
		
		//删除
//		int result = sqlSession.delete("mybatis-demo.deleteUser", 6L);
//		System.out.println("delete result:"+result);
		sqlSession.close();
	}
}
