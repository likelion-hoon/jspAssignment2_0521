<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="lg" class="jspbook3.addrbook.LoginBean" />
<jsp:useBean id="lgaddrbook" class="jspbook3.addrbook.LoginAddrBook" />
<jsp:setProperty name="lgaddrbook" property="*" />

<%
	String action = request.getParameter("action"); 
	
	// 회원 등록 요청인 경우 
	if(action.equals("insert")) {
		if(lg.insertDB(lgaddrbook)) {
			// 회원정보가 등록된후 로그인 페이지로 이동 
			response.sendRedirect("login_form.html");
		}
	}
	
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>