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
<h1>List Rrenewal</h1>
<p>	
<div class="container-fluid">
	<div class="col-md-7 my-100 mx-auto"></div>
		<table class="table table-striped table-hover">
			<tr>
				<th>BookNumber</th><th>BookName</th><th>BookRate</th><th>BookSale</th>
			</tr>
			
			<c:forEach items="${list}" var="dtos">
				<tr>
					<td>${dtos.bookNumber}</td>
					<td><a href="./bankbookSelect?bookNumber=${dtos.bookNumber}">${dtos.bookName}</a></td>
					<td>${dtos.bookRate}</td>
					<td>${dtos.bookSale}</td>
				</tr>
			</c:forEach>
		</table>
		
<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="./bankbookList" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
		   	<li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&lt;</span>
		      </a>
		    </li>
		    
		    	<!-- pager의 startNum부터 lastNum까지 찍음==>찍는걸 반복 -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><a class="page-link" href="./bankbookList?pn=${n}">${n}</a></li>
			</c:forEach> <!-- items 속성은 collection계열만 담당함 -->
			
			<li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.lastNum+1}" aria-label="Next">
		        <span aria-hidden="true">&gt;</span>
		      </a>
		    </li>
		   
		    <li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.totalPage}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		<a href="./bankbookInsert" class="btn btn-outline-success"">ADD</a>
	</div>
</div>
</p>
</body>
</html>