package vo;

public class User {
		private String username;
		private String user_password;
		private String user_cardid;
		private String user_phone;
		
		public User(String username, String user_password, String user_cardid, String user_phone) {
			super();
			this.username = username;
			this.user_password = user_password;
			this.user_cardid = user_cardid;
			this.user_phone = user_phone;
		}
		
		public User() {
			super();
			// TODO 自动生成的构造函数存根
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUser_password() {
			return user_password;
		}
		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}
		public String getUser_cardid() {
			return user_cardid;
		}
		public void setUser_cardid(String user_cardid) {
			this.user_cardid = user_cardid;
		}
		public String getUser_phone() {
			return user_phone;
		}
		public void setUser_phone(String user_phone) {
			this.user_phone = user_phone;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", user_password=" + user_password + ", user_cardid=" + user_cardid
					+ ", user_phone=" + user_phone + "]";
		}
		
		
}
