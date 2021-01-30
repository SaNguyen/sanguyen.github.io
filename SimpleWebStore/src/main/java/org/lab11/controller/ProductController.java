package org.lab11.controller;

import org.lab11.model.Product;
import org.lab11.model.Repository;
import org.lab11.model.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductController extends HttpServlet {
    Repository repo = new Repository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.print("Hello");
        String addCart = req.getParameter("addCart");
        if(addCart != null) {
            Integer productId = Integer.parseInt(req.getParameter("addCart"));
            Product product = repo.findProductById(productId);
            if (product != null) {
                HttpSession cartSession = req.getSession();
                ShoppingCart cart = (ShoppingCart) cartSession.getAttribute("shoppingCart");
                if (cart == null) {
                    cart = new ShoppingCart();
                }
                cart.addProduct(product);
                cartSession.setAttribute("shoppingCart", cart);
//                System.out.println(cartSession);
            }
        }

        req.setAttribute("products",repo.getProductList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("resources/jsp/products.jsp");
        dispatcher.forward(req, resp);

    }
}
