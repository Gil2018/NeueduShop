package biz;

import java.sql.SQLException;
import java.util.List;

import entity.NgmcUser;
import entity.PageBean;

public interface NgmcUserBiz {
	// 新增用户
	boolean addUser(NgmcUser user) throws SQLException;

	// 根据用户名和密码登录
	public NgmcUser login(String username, String pwd);



	// 检测用户是否被注册
	boolean isExeistscheckUser(String username) throws SQLException;

	//获取页面 无分页
	 List<NgmcUser> getUserlist();
	 //获取页面 有分页
	List<NgmcUser> getUserlistBypage(int currentPage,int pageSize);
	//总记录数
	int getUserCount();
}
