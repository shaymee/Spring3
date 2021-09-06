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
	
	<!-- Search Form -->
	
	<form action="./bankbookList" method="get">
		
		 <div class="input-group mb-3" >
		  <select name="kind" class="form-select form-select-sm" aria-label=".form-select-sm example">
			  <option value="num">Num</option>
			  <option value="name">Name</option>
			  <option value="rate">Rate</option>
			</select>
		  
		  <input type="text" name="search" class="form-control" aria-label="Text input with dropdown button">
		  <button type="submit" class="btn btn-outline-secondary">Search</button>
		</div>
			
		</form>
	
	<!-- /Search Form -->
	
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
		      <a class="page-link" href="./bankbookList?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
		   	<li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&lt;</span>
		      </a>
		    </li>
		    
		    	<!-- pager의 startNum부터 lastNum까지 찍음==>찍는걸 반복 -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><a class="page-link" href="./bankbookList?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
			</c:forEach> <!-- items 속성은 collection계열만 담당함 -->
			
			<li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&gt;</span>
		      </a>
		    </li>
		   
		    <li class="page-item">
		      <a class="page-link" href="./bankbookList?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
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