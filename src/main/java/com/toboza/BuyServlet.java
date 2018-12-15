package com.toboza;

import one.util.streamex.StreamEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    MySQLConnect sql = new MySQLConnect();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Stream<String> stream = StreamEx.of(req.getParameterNames());
        stream.forEach(e -> sql.putItem(
                req.getParameter("owner"),
                Integer.valueOf(req.getParameter("name")),
                Double.valueOf(req.getParameter(e))));

    }
}
