package com.java.springdemo.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.core.io.ClassPathResource;

public class FileUploadHandler extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String fileName = null;
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
    if (!isMultipartContent) {
      return;
    }
    FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    try {
      List<FileItem> fields = upload.parseRequest((RequestContext) request);
      Iterator<FileItem> it = fields.iterator();
      if (!it.hasNext()) {
        return;
      }
      while (it.hasNext()) {
        FileItem fileItem = it.next();
        boolean isFormField = fileItem.isFormField();
        if (isFormField) {
          if (fileName == null) {
            if (fileItem.getFieldName().equals("fileName")) {
              fileName = fileItem.getString();
            }
          }
        } else {
          if (fileItem.getSize() > 0) {
            fileItem.write(new File(new ClassPathResource("img/").getFile().getAbsolutePath() + "\\"
                + fileItem.getName()));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      out.println("<script type = 'text/javascript'>");
      out.println("window.location.href='index.jsp?filename=" + fileName + "'");
      out.println("</script>");
      out.close();
    }
  }
}
