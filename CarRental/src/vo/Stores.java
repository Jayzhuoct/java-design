package vo;

public class Stores {
		private String num;
		private String address;
		private String contact;
		private String adminname;
		private String admin_password;
						
		public Stores() {
			super();
			// TODO 自动生成的构造函数存根
		}
		public Stores(String num, String address, String contact, String adminname, String admin_password) {
			super();
			this.num = num;
			this.address = address;
			this.contact = contact;
			this.adminname = adminname;
			this.admin_password = admin_password;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getAdminname() {
			return adminname;
		}
		public void setAdminname(String adminname) {
			this.adminname = adminname;
		}
		public String getAdmin_password() {
			return admin_password;
		}
		public void setAdmin_password(String admin_password) {
			this.admin_password = admin_password;
		}
		@Override
		public String toString() {
			return "Stores [num=" + num + ", address=" + address + ", contact=" + contact + ", adminname=" + adminname
					+ ", admin_password=" + admin_password + "]";
		}
		
		
}
