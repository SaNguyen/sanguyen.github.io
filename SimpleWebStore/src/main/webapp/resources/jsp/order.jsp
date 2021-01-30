<%--
  Created by IntelliJ IDEA.
  User: sanguyen
  Date: 1/29/21
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='resources/css/order.css'/>" rel="stylesheet"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="orderList">

        <h1>Shopping Cart</h1>

        <c:forEach items="${shoppingCart.products}" var="product">
            <div class="order-item">
                <div class="image-item">
                    <a><img class="order-image-product" alt="" src="<c:url value="resources/image/${product.image}"/>"></a>
                </div>
                <div class="title-item">
                    ${product.title}
                </div>
                <div class="price-item">
                    ${product.price}
                </div>
                <div class="delete-button">
                    <a class="delete" href="<c:url value='order?action=delete&productId=${product.id}'/>">Delete</a>
                </div>
            </div>
        </c:forEach>
        <div class="group-button-checkout">
            <a class="button-check" href="<c:url value="/products"></c:url>">Shopping</a>
            <a class="button-check" href="<c:url value="/checkout"></c:url>">Checkout</a>

        </div>

    </div>


</body>
</html>
