package biz.impl;

import java.sql.SQLException;
import java.util.List;

import biz.NgmcUserBiz;
import dao.NgmcUserDao;
import dao.impl.NgmcUserDaoimpl;
import entity.NgmcUser;
import entity.PageBean;
import util.DBUtil;

public class NgmcUserBizImpl extends DBUtil implements NgmcUserBiz {
	//新增用户
	@Override
	public boolean addUser(NgmcUser user) throws SQLException {
		return new NgmcUserDaoimpl().save(user) > 0 ? true : false;
	}

	//登录验证
	@Override
	public NgmcUser login(String username, String pwd)  {
		NgmcUserDao userdao = new NgmcUserDaoimpl();
		NgmcUser user;
		try {
			user = userdao.getNgmcUserByNamePwd(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
		}
		return user;
	}

	//检测账户是否存在
	@Override
	public boolean isExeistscheckUser(String username) throws SQLException {
		return new NgmcUserDaoimpl().getNgmcUserByNumber(username) != null ? true : false;
	}

	@Override
	public List<NgmcUser> getUserlist() {
		try {
			return new NgmcUserDaoimpl().getUserlist();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<NgmcUser> getUserlistBypage(int currentPage, int pageSize)  {
		try {
			return new NgmcUserDaoimpl().getUserlistBypage(currentPage,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
	}

	@Override
	public int getUserCount()  {
		try {
			return new NgmcUserDaoimpl().getUserCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}


}
