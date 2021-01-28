package org.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class SupportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<html><head><title>Support</title></head><body>");
        out.print("<form method='post'> ");
        out.print("<div>Name:<p><input name='name'/></p></div>");
        out.print("<div>Email Address: <p><input name='email'/></p> </div>");
        out.print("<div>Problem:<p><input name='problem'/> </p> </div>");
        out.print("<div>Problem Description:<p><textarea name = 'prob_des'></textarea></p> </div>");
        out.print("<div><input type='submit' value='Help'/></div");
        out.print("</form>");
        out.print("</body></html>");


//        if(req.getSession(false) == null){
//            resp.sendRedirect("login");
//        }
//        else{
//            out.print("<html><head><title>Support</title></head><body>");
//            out.print("<form method='post'> ");
//            out.print("<div>Name:<p><input name='name'/></p></div>");
//            out.print("<div>Email Address: <p><input name='email'/></p> </div>");
//            out.print("<div>Problem:<p><input name='problem'/> </p> </div>");
//            out.print("<div>Problem Description:<p><textarea name = 'prob_des'></textarea></p> </div>");
//            out.print("<div><input type='submit' value='Help'/></div");
//            out.print("</form>");
//            out.print("</body></html>");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext contextPara = this.getServletContext();
        PrintWriter out = resp.getWriter();

        String support_email= contextPara.getInitParameter("support-email");
        String name = req.getParameter("name");
        String email= req.getParameter("email");
        String ticketId = generateTicketId();

//        out.print(name);
//        out.print(email);
//        out.print(ticketId);

        String output = "<html><head><title>Support</title></head><body>";
        output += "Thank you! <strong>" + name + "</strong> for contacting us. We should receive reply from us with in 24 hrs in " +
                "your email address <strong>" + email +"</strong>. Let us know in our support email <strong>" + support_email + "</strong> if " +
                "you don&apos;t receive reply within 24 hrs. Please be sure to attach your reference " +
                "<strong>" + ticketId + "</strong> in your email";
        output += "</body></html>";
        out.print(output);

    }
    private String generateTicketId(){
        return UUID.randomUUID().toString();

    }
}
