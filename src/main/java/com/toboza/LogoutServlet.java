package com.toboza;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if(cookies != null ){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("klient-shop")){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    resp.getWriter().println("<font color=red> Zostales poprawnie wylogowany</font>");
                    rd.include(req,resp);
                    resp.sendRedirect("index.jsp");
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}