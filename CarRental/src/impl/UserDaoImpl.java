package impl;

import java.util.List;
import dao.BaseDao;
import dao.IUserDao;
import vo.User;

public class UserDaoImpl extends BaseDao implements IUserDao{

	@Override
	public boolean insert(User u) {
		String sql ="insert into user(username,user_password,user_cardid,user_phone) values(?,?,?,?)";
		return update(sql,u.getUsername(),u.getUser_password(),u.getUser_cardid(),u.getUser_phone());
	}

	@Override
	public boolean delete(User u) {		
		String sql = "delete from user where username=?";
		return update(sql, u.getUsername());
	}

	@Override
	public boolean update(User u) {
		String sql = "update user set user_password=?,user_cardid=?,user_phone=? where username=?";
		return update(sql,u.getUsername(),u.getUser_password(),u.getUser_cardid(),u.getUser_phone());
	}

	@Override
	public User getById(String username) {
		String sql = "select username,user_password,user_cardid,user_phone from user where username=?";
		return getById(User.class,sql,username);
	}

	@Override
	public List<User> getList() {
		String sql = "select username,user_password,user_cardid,user_phone from user";
		List<User>list = getList(User.class,sql);
		return list;
	}
}