package com.lero.model;

public class LostInformation {
		//丢失物品信息
		private int lostid;//丢失物品编号
		private String lostphoto;
		private String losttitle;
		private String lostdetail;
		private String type;
		private String lostloginname;
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getLostid() {
			return lostid;
		}
		public void setLostid(int lostid) {
			this.lostid = lostid;
		}
		
		
		
		public String getLostloginname() {
			return lostloginname;
		}
		public void setLostloginname(String lostloginname) {
			this.lostloginname = lostloginname;
		}
		public String getLostphoto() {
			return lostphoto;
		}
		public void setLostphoto(String lostphoto) {
			this.lostphoto = lostphoto;
		}
		public String getLosttitle() {
			return losttitle;
		}
		public void setLosttitle(String losttitle) {
			this.losttitle = losttitle;
		}
		public String getLostdetail() {
			return lostdetail;
		}
		public void setLostdetail(String lostdetail) {
			this.lostdetail = lostdetail;
		}
		
		
}
