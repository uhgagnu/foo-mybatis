package cn.sunnyboy.dao;

import java.util.List;

import cn.sunnyboy.pojo.User;

public interface UserDao {

	//根据id查询用户
	public User queryUserById(long id);
	//查询所有的用户
	public List<User> queryAllUser();
	//新增用户
	public void saveUser(User user);
	//更新用户
	public void updateUser(User user);
	//删除用户
	public void deleteUser(long id);
}
