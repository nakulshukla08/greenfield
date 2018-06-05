<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Employees</title>
</head>
<body>
	<font color="red">${welcomeerrormessage}</font>
	<form method="post" id="empmanage">
		<table>
			<tr>
				<td><a href="addEmp" id="addEmp">Add Employee</a></td>
			</tr>
			<tr>
				<td><a href="Update Employee">Update Employee</a></td>
			</tr>
			<tr>
				<td><a href="Delete Employee">Delete Employee</a></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>
		</table>


	</form>

</body>
</html>