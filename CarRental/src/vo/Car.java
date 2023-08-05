package vo;

public class Car {
	private String carnum;
	private String cartype;
	private String num;
	private double price;
	private String color;
	private String hire;
	private String information;
	private String username;
	
	public Car(String carnum, String cartype, String num, double price, String color, String hire, String information,
			String username) {
		super();
		this.carnum = carnum;
		this.cartype = cartype;
		this.num = num;
		this.price = price;
		this.color = color;
		this.hire = hire;
		this.information = information;
		this.username = username;
	}
	
	public Car() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getHire() {
		return hire;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Car [carnum=" + carnum + ", cartype=" + cartype + ", num=" + num + ", price=" + price + ", color="
				+ color + ", hire=" + hire + ", information=" + information + ", username=" + username + "]";
	}
	
}
