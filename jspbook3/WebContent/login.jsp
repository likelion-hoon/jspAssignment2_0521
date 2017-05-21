<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jspbook3.addrbook.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="login" class="jspbook3.addrbook.LoginBean" scope="page" />
<jsp:setProperty name="login" property="*" />
<jsp:useBean id="lgaddrbook" class="jspbook3.addrbook.LoginAddrBook" />
<jsp:setProperty name="lgaddrbook" property="*" />


<%
	request.setCharacterEncoding("UTF-8"); 

	// login_form에서 입력한 id값과 passwd값 
	String user_id = request.getParameter("user_id");
	String passwd = request.getParameter("passwd");
	
    
	// 주소록 보는 것을 허용(로그인 성공)
	if (lgaddrbook.checkUser(user_id,passwd)) {
		response.sendRedirect("addrbook_control.jsp?action=list");
	} else { // 주소록 보는 것을 허용하지 않는다. 
		out.print("<script> alert('회원정보가 맞지 않습니다.'); </script>");
		out.print("<script> history.go(-1); </script>");
	}
%>


	



