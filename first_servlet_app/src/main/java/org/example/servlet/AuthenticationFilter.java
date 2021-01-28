package org.example.servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest in = (HttpServletRequest) request;
        HttpServletResponse out =  (HttpServletResponse)response;

        HttpSession session = in.getSession(false);
        if(session == null){
            out.sendRedirect("/login");
            return;
        }
        chain.doFilter(in, out);
    }

    @Override
    public void destroy() {

    }
}
