<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Customers</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relation Management</h2>
</div>
</div>
<div id="conatiner">
<div id ="content">

<input type="button" class="add-button" onClick="window.location.href='showFormForAdd'" value="Add Customer" >
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var ="tempCustomer" items="${customers}">
<tr>
<td> ${tempCustomer.firstName} </td>
<td> ${tempCustomer.lastName} </td>
<td> ${tempCustomer.email}</td>
<td>
<a href="${pageContext.request.contextPath}/customer/showFormForUpdate?customerId=${tempCustomer.id}">

Update
</a>
|
<a href="${pageContext.request.contextPath}/customer/delete?customerId=${tempCustomer.id}" onclick="if(!(confirm('Are you sure that you want to delete this?')))return false">
Delete
</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>