package com.toboza;

import one.util.streamex.StreamEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Stream;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    MySQLConnect sql = new MySQLConnect();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> e = req.getParameterNames();
        String owner = req.getParameter(e.nextElement());
        while (e.hasMoreElements()) {
            String param_name = e.nextElement();
            if (!req.getParameter(param_name).isEmpty()) {
                sql.putItem(owner, Integer.valueOf(param_name), Double.valueOf(req.getParameter(param_name)),0.0);

            }

        }


    }
}


/*  Stream<String> stream = StreamEx.of(req.getParameterNames());
        stream.forEach(e ->
                        System.out.println(req.getParameter(e)));
*/
