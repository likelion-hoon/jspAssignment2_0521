<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center"> 
	<h2> 회원가입  </h2>
	<hr>
		<form name="registration_form" method="POST"  action="login_control.jsp">
			
			<input type="hidden" name="action" value="insert"> 
			<table width="250" border="1" align="center" cellspacing="0" cellpadding="5">
				<tr>
				    <th> 아이디 </th>
					<td><input type="text" name="user_id" maxlength="20">
					</td>
				</tr>
				
				<tr>
				    <th> 비밀번호  </th>
					<td><input type="password" name="passwd" maxlength="20">
					</td>
				</tr>
				
				<tr>
				    <td colspan="2"><input type="submit" name="submit" value="입력완료"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>