package impl;

import java.util.List;
import dao.BaseDao;
import dao.IStoresDao;
import vo.Stores;

public class StoresDaoImpl extends BaseDao implements IStoresDao {

	@Override
	public boolean insert(Stores s) {
		String sql ="insert into stores(num,address,contact,adminname,admin_password) values(?,?,?,?,?)";
		return update(sql,s.getNum(),s.getAddress(),s.getContact(),s.getAdminname(),s.getAdmin_password());
	}

	@Override
	public boolean delete(Stores s) {
		String sql = "delete from stores where num=?";
		return update(sql, s.getNum());
	}

	@Override
	public boolean update(Stores s) {
		String sql = "update stores set address=?,contact=?,adminname=?,admin_password=? where num=?";
		return update(sql,s.getNum(),s.getAddress(),s.getContact(),s.getAdminname(),s.getAdmin_password());
	}

	@Override
	public Stores getById(String adminname) {		
		String sql = "select * from stores where adminname=?";
		return getById(Stores.class, sql, adminname);
	}

	@Override
	public List<Stores> getList() {	
		String sql = "select * from stores";
		List<Stores> list = getList(Stores.class,sql);
		return list;
	}
}
