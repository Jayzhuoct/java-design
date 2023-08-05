package factory;

import dao.IStoresDao;
import impl.StoresDaoImpl;

public class StoresFactory {
	public static IStoresDao getInstance() {
		return new StoresDaoImpl();
	}
}
