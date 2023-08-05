package dao;

import java.util.List;
import vo.Stores;

public interface IStoresDao {

	boolean update(Stores s);
	boolean delete(Stores s);
	boolean insert(Stores s);
	Stores getById(String num);
	List<Stores> getList();
}
