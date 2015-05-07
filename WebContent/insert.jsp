<%@page import="com.sds.icto.dao.EmailListDAO"%>
<%@page import="com.sds.icto.vo.EmailListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    EmailListDAO dao = new EmailListDAO();
	String fn = request.getParameter("fn");
	String ln = request.getParameter("ln");
	String email = request.getParameter("email");

	dao.insert(new EmailListVO(0, fn, ln, email));

	response.sendRedirect("/EmailSystem");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>