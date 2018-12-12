package com.toboza;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final String userFromDB = "Tom";
    private final String passwordFromDB = "haslo";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("pwd");

        if(user != null && user.equals(userFromDB)&& password != null && password.equals(passwordFromDB)){
            Cookie loginCookie = new Cookie("klient-shop",user);
            loginCookie.setMaxAge(30*60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("LoginSuccess.jsp");
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            resp.getWriter().println("<font color=red> Jestes niezalogowany albo bledne dane</font>");
            rd.include(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
