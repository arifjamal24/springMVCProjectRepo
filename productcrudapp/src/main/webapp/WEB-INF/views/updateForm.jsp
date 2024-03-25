<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
<body>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center mb-3">Update Product Detail</h2>
				<input type="hidden" name="id" value="${product.id }"/>
				<form action="${pageContext.request.contextPath }/productHandler" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input name="name"
							type="text" class="form-control" id="name"
							value="${product.name }">
					</div>
					<div class="form-group">
						<label for="desc">Product Description</label>
						<textarea class="form-control" id="desc" name="description"
							rows="5">${product.description }</textarea>
					</div>
					<div class="form-group">
						<label for="name">Product Price</label> <input name="price"
							type="text" class="form-control" id="price"
							value="${product.price }">
					</div>

					<div class="container  text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>

						<button class="btn btn-outline-warning" type="submit">Update Detail</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</html>