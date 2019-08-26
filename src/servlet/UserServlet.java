package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NgmcUserBiz;
import biz.impl.NgmcUserBizImpl;
import com.alibaba.fastjson.JSON;
import entity.NgmcUser;
import entity.PageBean;

import static java.lang.System.out;
import static java.lang.System.setSecurityManager;

/**
 * Servlet 控制层 -----调用业务层 MVC模型
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String method = request.getParameter("method");
        NgmcUserBiz NgmcUser1 = new NgmcUserBizImpl();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (method.equals("login")) {//执行登录
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            NgmcUser user = NgmcUser1.login(username, password);
            if (user != null) {//登录成功
                session.setAttribute("user",user); //在session中存储user信息
                session.setMaxInactiveInterval(2*60);//设置session的存活时间（单位秒）停止活动时开始计时
                response.sendRedirect(request.getContextPath() + "/index.html");
            } else {//登录失败
                //登录失败就再次跳转到登录页login.html
                response.sendRedirect(request.getContextPath() + "/login.html");

            }
        } else if (method.equals("registr")) {//执行注册
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String rpassword = request.getParameter("Rpassword");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");
            String skin = request.getParameter("skin");
            String ip = request.getRemoteAddr();
            NgmcUser user = new NgmcUser(userName, password, nickname, null, role,null, ip, "1", skin, email, null, phone,0);
            try {
                if (NgmcUser1.isExeistscheckUser(userName)) {
                    //登录失败就再次跳转到登录页login.html
                    response.sendRedirect(request.getContextPath() + "/login.html");
                } else {
                    if (NgmcUser1.addUser(user) && password == rpassword) {
                        //登录成功后会跳转到主页面index.html
                        response.sendRedirect(request.getContextPath() + "/index.html");
                    } else {//登录失败
                        //登录失败就再次跳转到登录页login.html
                        response.sendRedirect(request.getContextPath() + "/login.html");

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else if(method.equals("show")){
            NgmcUser user = (NgmcUser)session.getAttribute("user");
            //将User对象转化为Json格式的字符串
            // 若只有对象就用toJSONString,带日期就用toJSONStringWithDateFormat()方法
            String userJSON = JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd HH:mm:ss");

            out.print(userJSON);
        }else if(method.equals("loginOut")){
                session.invalidate(); //立刻让Session失效（清空session中所有的数据）
                response.sendRedirect(request.getContextPath()+"/login.html");
        }else if(method.equals("userlist")){
            //将用户列表转化为JSON数据
            List<NgmcUser> userList = NgmcUser1.getUserlist();
            String userListJSON = JSON.toJSONStringWithDateFormat(userList,"yyyy-MM-dd HH:mm:ss");
            out.print(userListJSON);
        }else if(method.equals("userlistPage")){
            int currentPage = request.getParameter("currentPage") == null?1:Integer.parseInt(request.getParameter("currentPage"));
            PageBean<NgmcUser> page = new PageBean<>();
            page.setCurrentPage(currentPage);
            page.setTotalCount(NgmcUser1.getUserCount());
            page.setPageData(NgmcUser1.getUserlistBypage(currentPage,page.getPageSize()));
            String userListPageJSON = JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss");
            out.print(userListPageJSON);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
