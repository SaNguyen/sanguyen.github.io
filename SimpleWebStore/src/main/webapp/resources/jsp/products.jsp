<%--
  Created by IntelliJ IDEA.
  User: sanguyen
  Date: 1/28/21
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" uri="org.example.my-custom-tag"%>

<link href="<c:url value='resources/css/products.css'/>" rel="stylesheet"/>


<html>
<head>
    <title>Products</title>
</head>
<body>


<div class="products">
    <div class="cart">
        <a href="order"><img src="resources/image/cart.png" /><span>${shoppingCart.size}</span>
        </a>
    </div>
    <div class="row-product">
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[0].image}" alt="${products[0].title}"/></a>
            <div class="info-product">${products[0].title}</div>
            <div class="price-product">$${products[0].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[0].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[1].image}" alt="${products[1].title}"/></a>
            <div class="info-product">${products[1].title}</div>
            <div class="price-product">$${products[1].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[1].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[2].image}" alt="${products[2].title}"/></a>
            <div class="info-product">${products[2].title}</div>
            <div class="price-product">$${products[2].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[2].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[3].image}" alt="${products[3].title}"/></a>
            <div class="info-product">${products[3].title}</div>
            <div class="price-product">$${products[3].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[3].id}';">
                    Add to cart
                </button>
            </div>
        </div>
    </div>
    <div class="row-product">
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[4].image}" alt="${products[4].title}"/></a>
            <div class="info-product">${products[4].title}</div>
            <div class="price-product">$${products[4].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[4].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[5].image}" alt="${products[5].title}"/></a>
            <div class="info-product">${products[5].title}</div>
            <div class="price-product">$${products[5].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[5].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[6].image}" alt="${products[6].title}"/></a>
            <div class="info-product">${products[6].title}</div>
            <div class="price-product">$${products[6].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[6].id}';">
                    Add to cart
                </button>
            </div>
        </div>
        <div class="one-product">
            <a href=""><img class="image-product" src="resources/image/${products[7].image}" alt="${products[7].title}"/></a>
            <div class="info-product">${products[7].title}</div>
            <div class="price-product">$${products[7].price}</div>
            <div class="add-to-cart">
                <button type="button" class="button-add" onclick="location.href='products?addCart=${products[7].id}';">
                    Add to cart
                </button>
            </div>
        </div>
    </div>
    <div class="customtag">
        <ct:currentDateTime size="15px" color="green"/>
    </div>
</div>
</body>
</html>
