package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
//        writer.print("Hello !");

        String username = (String)req.getSession().getAttribute("username");
        writer.print("Hello " + username + "!");


//        if(req.getSession(false) == null){
//            resp.sendRedirect("login");
//        }
//        else{
//            String username = (String)req.getSession().getAttribute("username");
//            writer.print("Hello " + username + "!");
//        }

    }

}
