package entity;

import java.util.Date;

public class NgmcUser {
	private String user_id;//用户id
	private String user_name;//用户名
	private String user_password;//密码
	private String nick_name;//昵称
	private String rights;//权限
	private String role_id;//角色id
	private Date last_login;//上次登录时间
	private String ip;//登录ip
	private String user_status;//状态
	private String skin;//皮肤样式
	private String email;//邮箱
	private String user_number;//固话号码
	private String phone;//手机
	private int man_buyer_id;//产商，借卖方id
	public NgmcUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NgmcUser(String user_name, String user_password, String nick_name, String rights,
					String role_id,Date last_login , String ip, String user_status, String skin, String email,
					String user_number, String phone,int man_buyer_id) {
		super();

		this.user_name = user_name;
		this.user_password = user_password;
		this.nick_name = nick_name;
		this.rights = rights;
		this.role_id = role_id;
		this.ip = ip;
		this.user_status = user_status;
		this.skin = skin;
		this.email = email;
		this.user_number = user_number;
		this.phone = phone;
		this.last_login = null ;
		this.man_buyer_id = 0 ;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMan_buyer_id() {
		return man_buyer_id;
	}
	public void setMan_buyer_id(int man_buyer_id) {
		this.man_buyer_id = man_buyer_id;
	}


}
