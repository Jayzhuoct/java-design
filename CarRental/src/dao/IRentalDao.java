package dao;

import java.util.List;
import vo.Rental;

public interface IRentalDao {
	boolean update(Rental r);
	boolean insert(Rental r);
	boolean delete(Rental r);
	List<Rental> getList();
}
