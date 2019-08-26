package dao;

import java.sql.SQLException;
import java.util.List;

import entity.NgmcUser;

public interface NgmcUserDao {
	// 新增用户信息
	int save(NgmcUser User) throws SQLException;

	// 根据用户名和密码获取用户信息
	NgmcUser getNgmcUserByNamePwd(String username, String pwd) throws SQLException;

	// 根据用户名检测用户是否注册
	NgmcUser getNgmcUserByNumber(String username) throws SQLException;

	//不带分页的用户表
	List<NgmcUser> getUserlist() throws SQLException;

	//带分页的用户表
	List<NgmcUser> getUserlistBypage(int currentPage,int pageSize) throws SQLException;
	//总记录数
	int getUserCount() throws SQLException;

}
