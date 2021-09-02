<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Bankbook List</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>List renewal</h1>
<p>	
<div class="container-fluid">
	<div class="col-md-7 my-100 mx-auto"></div>
		<table class="table table-striped table-hover">
			<tr>
				<th>BookNumber</th><th>BookName</th><th>BookRate</th><th>BookSale</th>
			</tr>
			
			<c:forEach items="${list}" var="dtos">
				<tr>
					<td><a href="./bankbookSelect?bookNumber=${dtos.bookNumber}">${dtos.bookNumber}</a></td>
					<td>${dtos.bookName}</td>
					<td>${dtos.bookRate}</td>
					<td>${dtos.bookSale}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="./bankbookInsert" class="btn btn-outline-success"">ADD</a>
	</div>
</div>
</p>
</body>
</html>