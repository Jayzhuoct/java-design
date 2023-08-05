package dao;

import java.util.List;

import vo.Car;
public interface ICarDao {
	boolean update(Car c);
	boolean insert(Car c);
	boolean delete(Car c);
	Car getById(String CarNum);
	List<Car> getList();
}
