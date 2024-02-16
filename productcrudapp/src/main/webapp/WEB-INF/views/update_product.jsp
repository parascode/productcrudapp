<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="./base.jsp"></jsp:include>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3 ">
				<h1 class="text-center mb-3">Update Product Details</h1>
				<form action="${pageContext.request.contextPath}/handle-product" method="post">
					<input type="hidden" name="id" value="${product.id }">
					<div class="form-group">
						<label for="name">Product name</label> 
						<input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter the product name here"
							value="${product.name}"
							>
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" id="description" name="description"
							rows="5" placeholder="Enter the product description here">${product.description }</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product price</label> 
						<input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter product price here" value="${product.price }" >
					</div>
					<div class="container form-group text-center">
						<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-warning">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>