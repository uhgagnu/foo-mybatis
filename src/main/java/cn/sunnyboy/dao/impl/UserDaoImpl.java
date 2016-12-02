package cn.sunnyboy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.sunnyboy.dao.UserDao;
import cn.sunnyboy.pojo.User;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public User queryUserById(long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("mybatis-demo.queryUserById", 1L);
		return user;
	}

	public List<User> queryAllUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession.selectList("mybatis-demo.queryAllUser");
	}

	public void saveUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("mybatis-demo.saveUser", user);
	}

	public void updateUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("mybatis-demo.updateUser", user);
	}

	public void deleteUser(long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("mybatis-demo.deleteUser", 6L);
	}

	
}
