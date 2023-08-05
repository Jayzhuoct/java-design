package factory;

import dao.IRentalDao;
import impl.RentalDaoImpl;

public class RentalFactory {
	public static IRentalDao getInstance() {
		return new RentalDaoImpl();
	}
}
