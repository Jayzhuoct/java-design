package factory;

import dao.ICarDao;
import impl.CarDaoImpl;

public class CarFactory {
	public static ICarDao getInstance() {
		return new CarDaoImpl();
	}
}
