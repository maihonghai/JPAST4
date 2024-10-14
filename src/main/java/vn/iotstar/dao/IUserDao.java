package vn.iotstar.dao;
import java.util.List;

import vn.iotstar.entity.User;

public interface IUserDao {
	void insert(User user);
    void update(User user);
    void delete(int userId);
    User findById(int userId);
    List<User> searchByName(String username);
    List<User> findAll();

}
