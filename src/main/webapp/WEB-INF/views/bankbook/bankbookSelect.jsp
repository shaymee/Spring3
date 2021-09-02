<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bankbook Select</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Welcome Bankbook Select!</h1>
<p>
	<div class="container-fluid">
		<table class="table table-striped table-hover">
			<tr>
				<th>BookNumber</th><th>BookName</th><th>BookRate</th><th>BookSale</th>
			</tr>
				<tr>
					<td>${dtov.bookNumber}</td>
					<td>${dtov.bookName}</td>
					<td>${dtov.bookRate}</td>
					<td>${dtov.bookSale}</td>
				</tr>
		</table>
		<a href="./bankbookDelete?bookNumber=${dtov.bookNumber}" class="btn btn-dark">Delete</a>
	</div>
</p>
</body>
</html>