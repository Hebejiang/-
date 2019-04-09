package com.lero.model;





public class User                              {
	 
		private String loginname;
		private String password;
		private String name;
		private String mailbox;
		private String phonenumber;
		public User()
		{
			
		}
		public User(String loginname,String password)
		{
			this.loginname=loginname;
			this.password = password;
		}
		public String getMailbox() {
			return mailbox;
		}
		public void setMailbox(String mailbox) {
			this.mailbox = mailbox;
		}
		
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
