package impl;

import java.util.List;
import dao.BaseDao;
import dao.ICarDao;
import vo.Car;

public class CarDaoImpl extends BaseDao implements ICarDao {

	@Override
	public boolean insert(Car c) {
		String sql = "insert into car(carnum,cartype,num,price,color,hire,information,username) values(?,?,?,?,?,?,?,?)";
		return update(sql,c.getCarnum(),c.getCartype(),c.getNum(),c.getPrice(),c.getColor(),c.getHire(),c.getInformation(),c.getUsername());		
	}

	@Override
	public boolean delete(Car c) {
		String sql = "delete from car where carnum=?";
		return update(sql, c.getCartype());	
	}

	@Override
	public boolean update(Car c) {
		String sql = "update car set cartype=?,num=?,price=?,color=?,hire=?,information=?,username=null where carnum=?";		
		return update(sql,c.getCarnum(),c.getCartype(),c.getNum(),c.getPrice(),c.getColor(),c.getInformation());
	}

	@Override
	public Car getById(String CarNum) {
		String sql = "select * from car where carnum=?";
		return getById(Car.class, sql,CarNum);		
	}

	@Override
	public List<Car> getList() {
		String sql = "select carnum,cartype,num,price,color,hire,information,username from car";
		List<Car> list = getList(Car.class,sql);
		return list;		
	}
}


