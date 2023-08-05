package service;

import java.util.List;

import factory.CarFactory;
import factory.StoresFactory;
import vo.Car;
import vo.Stores;

public class AdminService {
	public boolean addcar(Car c) {
		if(CarFactory.getInstance().getById(c.getCarnum())==null) {
		return CarFactory.getInstance().insert(c);
		}
		else {
			return false;
		}
	}
	
	public boolean deletecar(Car c) {
		if (CarFactory.getInstance().getById(c.getCarnum())!=null) {
			return CarFactory.getInstance().delete(c);
		}
		else {
			return false;
		}
	}
	
	public boolean updatecar(Car c) {
		if (CarFactory.getInstance().getById(c.getCarnum())!=null) {
			return CarFactory.getInstance().update(c);
		}
		else {
			return false;
		}
	}
	
	public Car showCar(Car c) {
		if (CarFactory.getInstance().getById(c.getCarnum())!=null) {
			 return CarFactory.getInstance().getById(c.getCarnum());
		}
		else {
			return null;
		}
	}
	
	public List<Car> showAllCar(Car c) {
		return CarFactory.getInstance().getList();
	}
	
	public boolean addStores(Stores s) {
		if(StoresFactory.getInstance().getById(s.getNum())==null) {
		return StoresFactory.getInstance().insert(s);
		}
		else return false;
	}
	
	public boolean deletestores(Stores s) {
		if (StoresFactory.getInstance().getById(s.getNum())!=null) {
			return StoresFactory.getInstance().insert(s);
		}
		else {
			return false;
		}
	}
	
	public boolean updatestores(Stores s) {
		if (StoresFactory.getInstance().getById(s.getNum())!=null) {
			return StoresFactory.getInstance().update(s);
		}
		else {
			return false;
		}
	}
	
	public Stores showStores(Stores s) {
		return StoresFactory.getInstance().getById(s.getAdminname());
	}
	
	public List<Stores> showAllStorse(Stores s) {
		return StoresFactory.getInstance().getList();
	}
}
