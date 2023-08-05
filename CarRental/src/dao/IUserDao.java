package dao;

import java.util.List;
import vo.User;

public interface IUserDao {
	boolean update(User u);
	boolean insert(User u);
	boolean delete(User u);
	User getById(String username);
	List<User> getList();
}
