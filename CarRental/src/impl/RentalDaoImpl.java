package impl;

import java.util.List;
import dao.BaseDao;
import dao.IRentalDao;
import vo.Rental;

public class RentalDaoImpl extends BaseDao implements IRentalDao {

	@Override
	public boolean insert(Rental r) {
		String sql = "insert into rental(num,username,days,allprice) values(?,?,?,?,)";
		return update(sql,r.getCarnum(),r.getUsername(),r.getDays(),r.getAllprice());		
	}

	@Override
	public boolean delete(Rental r) {
		String sql = "delete from rental where username=?";
		return update(sql, r.getUsername());
	}

	@Override
	public boolean update(Rental r) {		
		String sql = "update rental set carnum=?,days=?,allprice=? where username=?";
		return update(sql, r.getCarnum(),r.getUsername(),r.getDays(),r.getAllprice());
	}

	@Override
	public List<Rental> getList() {
		String sql = "select * from rental";
		List<Rental> list = getList(Rental.class,sql);
		return list;
	}
}
