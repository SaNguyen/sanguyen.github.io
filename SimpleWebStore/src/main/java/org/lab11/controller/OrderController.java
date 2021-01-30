package org.lab11.controller;

import org.lab11.model.Product;
import org.lab11.model.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart cart = (ShoppingCart)req.getSession().getAttribute("ShoppingCart");
//        for( Product p : cart.getProducts()){
//            System.out.println(p.getTitle());
//        }

//        req.setAttribute("order",cart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("resources/jsp/order.jsp");
        dispatcher.forward(req, resp);


    }
}
