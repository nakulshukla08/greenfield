<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Employees</title>
</head>
<body>
	<font color="red">${addmessage}</font>
	<form method="post">
		<table>
			<tr>
				<td>Employee Id :</td>
				<td><input type="text" name="EmpId"></td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td><input type="text" name="EmpName"></td>
			</tr>
			<tr>
				<td>Employee Age :</td>
				<td><input type="text" name="EmpAge"></td>
			</tr>
			<tr>
				<td>Employee Salary :</td>
				<td><input type="text" name="EmpSalary"></td>
			</tr>
			<tr>
				<td>Employee Department :</td>
				<td><input type="text" name="EmpDepartment"></td>
			</tr>
			<tr>
				<td>Employee Role :</td>
				<td><input type="text" name="EmpRole"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>


	</form>

</body>
</html>