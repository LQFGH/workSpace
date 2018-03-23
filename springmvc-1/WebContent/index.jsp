<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br><br>
	<a href="springmvc/testRedirect">testRedirect</a>
	<br><br>
	<a href="springmvc/excelView">ExcelView</a>
	<br><br>
	<a href="springmvc/testView">HellowView</a>
	<br><br>
	<a href="springmvc/testViewAndViewReslver">TestViewAndViewReslver</a>
	<br><br>

	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"/>
		<input type="text" name="username" value="LuHan"/>
		<input type="text" name="email" value="LuHan@...com"/>
		<input type="submit"/>
	</form>

	<br><br>
	<a href="springmvc/testSessionAttribute">TestSessionAttribute</a>
	<br><br>
	<a href="springmvc/testMap">TestMap</a>
	<br><br>
	<a href="springmvc/testModelAndView">TestModelAndView</a>
	<br><br>
	<a href="springmvc/testServletApi">TestServletApi</a>
	<br><br>
	<a href="springmvc/testCookieValue">TestRequestHeader</a>
	<br><br>
	<a href="springmvc/testRequestHeader">TestRequestHeader</a>
	<br><br>
	<form action="springmvc/testPOJO" method="post">
		<table>
			<tr>
				<td>UserName：</td>
				<td><input type="text" name="username" /></td>

			</tr>
			<tr>
				<td>PassWord：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>City：</td>
				<td><input type="text" name="address.city" /></td>
			</tr>
			<tr>
				<td>Street：</td>
				<td><input type="text" name="address.street" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="testPOJO" /></td>
			</tr>
		</table>
	</form>
	<br>
	<br>

	<a href="springmvc/testRequestParam?username=LQF&age=22">TestRequestParam</a>

	<br>
	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="TestPut" />
	</form>

	<br>
	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="TestDelete" />
	</form>

	<br>
	<br>

	<form action="springmvc/testRest" method="post">

		<input type="submit" value="TestPost" />
	</form>

	<br>
	<br>
	<a href="springmvc/testRest/1">TestGet Page</a>
	<br>
	<br>

	<a href="springmvc/testAntPath/123/abc">TesAntPath Page</a>
	<br>
	<br>
	<a href="springmvc/testParams?username=LQF&age=10">TestParams Page</a>
	<br>
	<br>
	<a href="helloworld">Hello World</a>
	<br>
	<br>
	<a href="springmvc/testRequestMapping">TestRequestMapping Page</a>
	<br>
	<br>
	<a href="springmvc/testMethod">TestMethod Page</a>

</body>
</html>