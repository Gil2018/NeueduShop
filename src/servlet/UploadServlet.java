package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uploadFileName = ""; //上传的文件名
        String fieldName = "";  //表单字段元素的name属性值
        //请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
        String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/" );
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                //解析form表单中所有文件
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {   //依次处理每个文件
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()){  //普通表单字段
                        fieldName = item.getFieldName();   //表单字段的name属性值
                        if (fieldName.equals("user")){
                            //输出表单字段的值
                            System.out.print(item.getString("UTF-8")+"上传了文件。<br/>");
                        }
                    }else{  //文件表单字段
                        String fileName = item.getName();
                        if (fileName != null && !fileName.equals("")) {
                            File fullFile = new File(item.getName());
                            File saveFile = new File(uploadFilePath, fullFile.getName());
                            item.write(saveFile);
                            uploadFileName = fullFile.getName();
                            System.out.print("上传成功后的文件名是："+uploadFileName);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
