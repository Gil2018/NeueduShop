package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NgmcUserDao;
import entity.NgmcUser;
import util.DBUtil;

public class NgmcUserDaoimpl extends DBUtil implements NgmcUserDao {
    //添加新用户
    @Override
    public int save(NgmcUser user) throws SQLException {
        String sql = "insert into ngmc_user(user_name,user_password, nick_name, rights,role_id,last_login,ip,user_status,skin,email,user_number,phone)"
                + " values (?,?,?,?,?,null,?,?,?,?,?,?)";
        return executeUpdate(sql, user.getUser_name(), user.getUser_password(), user.getNick_name(), user.getRights(), user.getRole_id(),
                user.getIp(), user.getUser_status(), user.getSkin(), user.getEmail(), user.getUser_number(), user.getPhone());
    }

    //根据用户名和密码获取用户信息
    @Override
    public NgmcUser getNgmcUserByNamePwd(String username, String pwd) throws SQLException {
        NgmcUser user = null;
        String sql = "select  user_id,user_name,user_password, nick_name, rights,role_id,last_login,ip,user_status,skin,email,user_number,phone,man_buyer_id"
                + " from ngmc_user where user_name =? and user_password=?";
        rs = executeQuery(sql, username, pwd);
        if (rs.next()) {
            user = new NgmcUser(username, pwd, rs.getNString("nick_name"), rs.getString("rights"),
                    rs.getString("role_id"), rs.getDate("last_login"), rs.getString("ip"), rs.getString("user_status"), rs.getString("skin"), rs.getString("email"), rs.getString("user_number"),
                    rs.getString("phone"), 0);
        }
        return user;
    }

    //根据用户名获取用户信息
    public NgmcUser getNgmcUserByNumber(String username) throws SQLException {
        NgmcUser user = null;
        String sql = "select  user_id,user_name,user_password, nick_name, rights,role_id,last_login,ip,user_status,skin,email,user_number,phone,man_buyer_id"
                + " from ngmc_user where user_name =?";
        rs = executeQuery(sql, username);
        if (rs.next()) {
            user = new NgmcUser(username, rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                    rs.getString(11), rs.getString(12), rs.getInt(13));
        }
        return user;
    }

    @Override
    public List<NgmcUser> getUserlist() throws SQLException {
        List<NgmcUser> userList = new ArrayList<>();
        String sql = "select  user_name,user_password, nick_name, rights,role_id,last_login,ip,user_status,skin,email,user_number,phone,man_buyer_id"
                + " from ngmc_user";
        try {
            rs = executeQuery(sql);

            NgmcUser user = null;
            while (rs.next()) {
                user = new NgmcUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13));
                userList.add(user);
            }
        }finally {
            closeAll(conn, pstmt, rs);
        }
        return userList;
    }


    @Override
    public List<NgmcUser> getUserlistBypage(int currentPage, int pageSize) throws SQLException {
        List<NgmcUser> userList = new ArrayList<>();
        String sql = "select  user_name,user_password, nick_name, rights,role_id,last_login,ip,user_status,skin,email,user_number,phone,man_buyer_id"
                + " from ngmc_user limit ? , ?";
        try {
            rs = executeQuery(sql, (currentPage - 1) * pageSize, pageSize);

            NgmcUser user = null;
            while (rs.next()) {
                user = new NgmcUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13));
                userList.add(user);
            }
        }finally {

        }
        return userList;
    }

    @Override
    public int getUserCount() throws SQLException {
        int count = 0;
        String sql = "select count(user_id) from ngmc_user";
        try {
            rs = executeQuery(sql, null);
            if (rs.next()) {
                count = rs.getInt(1);

            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return count;

    }

}
