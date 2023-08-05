package factory;

import dao.IUserDao;
import impl.UserDaoImpl;

public class UserFactory {
	public static IUserDao getInstance() {
		return new UserDaoImpl();
	}
}
