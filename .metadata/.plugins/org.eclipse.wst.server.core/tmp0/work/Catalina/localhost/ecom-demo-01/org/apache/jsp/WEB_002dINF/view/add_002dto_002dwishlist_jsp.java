/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-08-01 16:08:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.java.springdemo.util.SortUtils;

public final class add_002dto_002dwishlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1672392693925L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-5.3.9 - Copy.jar", Long.valueOf(1672392814948L));
    _jspx_dependants.put("jar:file:/C:/Users/prashantjapkar/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ecom-demo-01/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323238578000L));
    _jspx_dependants.put("jar:file:/C:/Users/prashantjapkar/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ecom-demo-01/WEB-INF/lib/spring-webmvc-5.3.9%20-%20Copy.jar!/META-INF/spring-form.tld", Long.valueOf(1626224864000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.java.springdemo.util.SortUtils");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<link rel=\"icon\" href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/icon/my4.ico'>\r\n");
      out.write("<title>Wish List</title>\r\n");
      out.write("<style>\r\n");
      out.write("	body {\r\n");
      out.write("		margin: 0;\r\n");
      out.write("		font-family: Arial, sans-serif;\r\n");
      out.write("		background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black overlay */\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: center;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("		min-height: 100vh;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.modal {\r\n");
      out.write("		background-color: #fff; /* Set a white background color for the content */\r\n");
      out.write("		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Add a subtle box shadow */\r\n");
      out.write("		padding: 20px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		max-width: 400px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	h3 {\r\n");
      out.write("		color: #555; /* Set a dark grey color for the heading */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	p {\r\n");
      out.write("		color: #777; /* Set a lighter grey color for the paragraph */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.button {\r\n");
      out.write("		padding: 10px 20px;\r\n");
      out.write("		border: none;\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("		font-size: 16px;\r\n");
      out.write("		border-radius: 4px;\r\n");
      out.write("		margin: 10px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.button-no {\r\n");
      out.write("		background-color: #f44336; /* Use a red color for \"Go Back\" button */\r\n");
      out.write("		color: #fff;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.button-yes {\r\n");
      out.write("		background-color: #4CAF50; /* Use a green color for \"Go to WishList\" button */\r\n");
      out.write("		color: #fff;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.close_popup {\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		top: 0;\r\n");
      out.write("		right: 0;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("		color: #fff;\r\n");
      out.write("		font-size: 20px;\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"modal\">\r\n");
      out.write("		<span class=\"close_popup\"><i class=\"fas fa-times\"></i></span>\r\n");
      out.write("		<div class=\"text-wrapper\">\r\n");
      out.write("			<h3>Successfully Added To WishList!</h3>\r\n");
      out.write("			<p>We will pass wishlist attribute in the model and show product details here</p>\r\n");
      out.write("			<button class=\"button button-no\" onclick=\"window.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/product/getProducts?section=All';\">Go Back</button>\r\n");
      out.write("			<button class=\"button button-yes\" onclick=\"window.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/user/addWishListItem';\">Go To WishList</button>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}