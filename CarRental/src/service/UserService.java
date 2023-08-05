package service;

import java.util.List;

import factory.UserFactory;
import vo.User;

public class UserService {

	public boolean add(User u) {
		if(UserFactory.getInstance().getById(u.getUsername())==null)
		return UserFactory.getInstance().insert(u);
		else return false;
	}	

	public boolean delete(User u) {
		if(UserFactory.getInstance().getById(u.getUsername())!=null)
		return UserFactory.getInstance().delete(u);
		else return false;
	}
	

	public boolean update(User u) {
		if(UserFactory.getInstance().getById(u.getUsername())!=null)
		return UserFactory.getInstance().update(u);
		else return false;
	}

	public User showUser(User u) {
		/*if(UserFactory.getInstance().getByUserName(u.getUsernanme())!=null)
		{
			return UserFactory.getInstance().getByUserName(u.getUsernanme());
		}
		else {
			return null;
		}*/
		return UserFactory.getInstance().getById(u.getUsername());
	}

	public List<User> showAllUser(User u) {
		return UserFactory.getInstance().getList();
	}
}
