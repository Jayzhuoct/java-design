package vo;

public class Rental {
	private String carnum;
	private String username;
	private int days;
	private int allprice;
	public Rental() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Rental(String carnum, String username, int days, int allprice) {
		super();
		this.carnum = carnum;
		this.username = username;
		this.days = days;
		this.allprice = allprice;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getAllprice() {
		return allprice;
	}
	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}
	@Override
	public String toString() {
		return "Rental [carnum=" + carnum + ", username=" + username + ", days=" + days + ", allprice=" + allprice
				+ "]";
	}
	
	
}