<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bankbook Insert</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Update Page!</h1>

<div class="container-fluid">
	<form class="col-md-5 mx-auto" action="./bankbookUpdate" method="post">
		<input type="hidden" readonly="readonly" value="${dto.bookNumber}" name="bookNumber"> <!-- name속성은 parameter명 -->
		
		<div class="mb-3">
		  <label for="bookName" class="form-label">Book Name</label>
		  <input type="text" class="form-control" value="${dto.bookName}" name="bookName" id="bookName" placeholder="Enter BookName">
		</div>
		<div class="mb-3">
		  <label for="bookRate" class="form-label">Book Rate</label>
		  <input type="text" class="form-control" value="${dto.bookRate}" name="bookRate" id="bookRate" placeholder="Enter BookRate ex)0.00">
		</div>
		
		<!-- 문자열로 '1' 해도 됨 -->
		<c:if test="${dto.bookSale eq 1}"> 
		<div class="form-check mb-3">
			<input class="form-check-input" type="radio" name="bookSale" value="1" id="flexRadioDefault1" checked="checked">
			<label class="form-check-label" for="bookSale">
				Sale
			</label>
		</div>
		<div class="form-check mb-3">
		  <input class="form-check-input" type="radio" name="bookSale" value="0" id="flexRadioDefault2">
		  <label class="form-check-label" for="bookSale">
		    Not Sale
			</label>
		</div>		
		</c:if>
		
		<c:if test="${dto.bookSale == 0}">
			<div class="form-check mb-3">
			  <input class="form-check-input" type="radio" name="bookSale" value="1" id="flexRadioDefault1" >
			  <label class="form-check-label" for="bookSale">
			    Sale
			  </label>
			</div>
			<div class="form-check mb-3">
			  <input class="form-check-input" type="radio" name="bookSale" value="0" id="flexRadioDefault2" checked="checked">
			  <label class="form-check-label" for="bookSale">
			    Not Sale
				</label>
			</div>
		</c:if>





<%-- 		<c:choose>
			<c:when test="${dto.boolSale eq 1}">
				<div class="form-check mb-3">
					<input class="form-check-input" type="radio" name="bookSale" value="1" id="flexRadioDefault1" checked="checked">
					<label class="form-check-label" for="bookSale">
						Sale
					</label>
				</div>
				<div class="form-check mb-3">
					 <input class="form-check-input" type="radio" name="bookSale" value="0" id="flexRadioDefault2">
				  	 <label class="form-check-label" for="bookSale">
				    	Not Sale
					</label>
				</div>					
			</c:when>
			<c:otherwise>
				<div class="form-check mb-3">
				  <input class="form-check-input" type="radio" name="bookSale" value="1" id="flexRadioDefault1" >
				  <label class="form-check-label" for="bookSale">
				    Sale
				  </label>
				</div>
				<div class="form-check mb-3">
				  <input class="form-check-input" type="radio" name="bookSale" value="0" id="flexRadioDefault2" checked="checked">
			  	<label class="form-check-label" for="bookSale">
			    	Not Sale
				</label>
			 </div>
			</c:otherwise>
		</c:choose>
 --%>
		
		<button type="submit" class="btn btn-dark">Update</button>

	</form>
</div>

</body>
</html>