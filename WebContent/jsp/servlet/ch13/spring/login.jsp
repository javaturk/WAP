<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Spring</title>
</head>
<body>
	<div align="center">
		<H2 ALIGN="CENTER">Login Page</H2>

		<form action="/WAP3.4/spring/loginSpring.do" method="post">
			<h3>
				<table border="2">
					<tr>
						<td><b>Username:</b></td>
						<td><input type=text name=username size=30 maxlength=20></td>
					</tr>
					<tr>
						<td><b>Password:</b></td>
						<td><input type=password name=password size=30 maxlength=20></td>
					</tr>
					<tr>
						<td align=right><b>Role:</b></td>
						<td align=left><input type=radio name=role value=branchuser
							checked>Branch User <input type=radio name=role
							value=departmentuser>Department User</td>
					</tr>

					<tr />
					<tr valign=top>
						<td align=right><b></b></td>
						<td align=left><input type=radio name=role value=poweruser>Power
							User <input type=radio name=role value=admin>Admin</td>
					</tr>

					<tr>

						</td>
						<td colspan="2"><input type="submit" value="Login"
							style="font-family: sans-serif; font-size: 20px;" /> <input
							type=reset id=button value=Clear
							style="font-family: sans-serif; font-size: 20px;"></td>

					</tr>
				</table>
			</h3>
		</form>
	</div>
</body>
</html>