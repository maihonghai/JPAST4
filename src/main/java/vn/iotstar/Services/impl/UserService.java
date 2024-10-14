package vn.iotstar.Services.impl;

import java.util.List;

import vn.iotstar.Services.IUserService;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;

public class UserService implements IUserService{
	private IUserDao userDao;
	
	 public UserService() {
	        this.userDao = new UserDao();  // Khởi tạo Dao, bạn có thể sử dụng Dependency Injection (DI) nếu cần
	    }

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User findById(int userId) {
		 return userDao.findById(userId);
	}

	@Override
	public List<User> searchByName(String username) {
		return userDao.searchByName(username);
	}

	@Override
	public List<User> findAll() {
		 return userDao.findAll();
	}

}
