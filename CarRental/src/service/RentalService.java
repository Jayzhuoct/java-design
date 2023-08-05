package service;

import factory.RentalFactory;
import vo.Rental;


public class RentalService {
	public boolean addRental(Rental r) {		
		return RentalFactory.getInstance().insert(r);		
	}	

	public boolean deleteRental(Rental r) {
		if(RentalFactory.getInstance().getList()!=null) {
		return RentalFactory.getInstance().delete(r);
		}
		else {
			return false;
		}
	}
	
	public boolean updateRental(Rental r) {		
		return RentalFactory.getInstance().update(r);		
	}
	
	public java.util.List<Rental> showRental(Rental r) {		
		return RentalFactory.getInstance().getList();
	}
}
