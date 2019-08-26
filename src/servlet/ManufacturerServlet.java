package servlet;

import biz.NgmcManufacturerBiz;
import biz.impl.NgmcManufacturerBizImpl;
import entity.NgmcManufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ManufacturerServlet")
public class ManufacturerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String method = request.getParameter("method");
        NgmcManufacturerBiz NgmcUser1 = new NgmcManufacturerBizImpl();

        if (method.equals("add")) {
            String nameC = request.getParameter("nameC");
            String nameE = request.getParameter("nameE");
            String description = request.getParameter("description");
            String report_type = request.getParameter("report_type");
            String report_url = request.getParameter("report_url");
            NgmcManufacturer Manu = new NgmcManufacturer(nameE, nameC, report_type, report_url, description);
            try {
                if(NgmcUser1.addM(Manu)>0){
                    response.sendRedirect(request.getContextPath()+"/brand-brandInput.html");

                }else {
                    response.sendRedirect(request.getContextPath()+"/brand-addbrand.html");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath()+"/brand-brandInput.html");
            }


        }
    }
}
