package org.lab11.controller;

import org.lab11.model.Repository;
import org.lab11.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginController extends HttpServlet {
    private Repository repo = new Repository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Boolean loginStatus = Boolean.parseBoolean(req.getParameter("login_fail"));
        String userName="";
        String password="";
        String promo="";

        Cookie[] cookies = req.getCookies();
        if(cookies !=null) {
            for (Cookie cookie : req.getCookies()) {
                if(cookie != null) {
                    if (cookie.getName().equals("username")) {
                        userName = cookie.getValue();
                    }else if(cookie.getName().equals("password"))
                    {
                        password = cookie.getValue();
                    }
                }
            }
        }

        String isRemember = (userName != "") ? "checked" : "";
        out.print("<html><head><title>Support</title></head><body>");
        if(loginStatus){
            out.print("<div style='color:red'> Login fail. Please try again! </div> ");
        }
        out.print("<form method='post'> ");
        out.print("User name:<input name='username' value='" +  userName + "'/>");
        out.print("<p>Password: <input type='password' name='password'/> ");
//        out.print("<p>Password: <input type='password' name='password' value='" +  password + "'/> ");
        out.print("<p><input type='checkbox' name='remember_me' " + isRemember + "/>Remember me");
        out.print("<p><input type='submit' value='Login'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember_me");
        String promo = "$100";

        User user = new User(userName,password);
        if(!repo.findUser(user)) {
            resp.sendRedirect("login?login_fail=true");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("username", userName);

            Cookie usernameCookie = new Cookie("username",userName);
//            Cookie passwordCookie = new Cookie("password",password);
            Cookie promoCookie = new Cookie("promo",promo);
            promoCookie.setMaxAge(30*24*60*60);

            if(rememberMe != null){
                usernameCookie.setMaxAge(30*24*60*60);
//                passwordCookie.setMaxAge(30*24*60*60);

            }else{
                usernameCookie.setMaxAge(0);
//                passwordCookie.setMaxAge(0);
            }

            resp.addCookie(usernameCookie);
//            resp.addCookie(passwordCookie);
//            resp.addCookie(promoCookie);

            resp.sendRedirect("/checkout");

        }

    }
}