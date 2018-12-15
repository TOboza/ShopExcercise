<%@ page import="com.toboza.MySQLConnect" %>
<%@ page import="com.toboza.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zalogowano</title>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("klient-shop")) {
                userName = cookie.getValue();
            }
        }
    }
    if (userName == null) {
        response.sendRedirect("index.jsp");
    }
%>
<h3> Witaj użytkowniku <%=userName%>
</h3>

<div style="position:absolute; top:10px ; right:40px">
    <form action="LogoutServlet" method="post">
        <input type="submit" value="LOGOUT">
    </form>
</div>

<h3><p> Rzeczy w sklepie :</p></h3>
<form action="BuyServlet" method="post">
<%
    MySQLConnect conn = new MySQLConnect();

    List<Item> lista = conn.getItemBase();
    %> <input name="owner" type=hidden value="<%=userName%>" /><%
    for (Item x : lista) { %> <br><input  name="<%=x.getId()%>" type="text" id=<%=x.getId()%>  cols="1" rows="1"/>
                                   <%
        out.println(x.toString());
    }

    ;%>
<BR>
<input type="submit"  value="Kupuję!"/>
</form>
<%--<%--%>
        <%--for (String atrib : request.getParameterValues("Kup")) {--%>
        <%--int attribNumber = Integer.valueOf(atrib);--%>
        <%--conn.putItem(userName,attribNumber,lista.get(attribNumber).getCena());--%>

    <%--}--%>
<%--%>--%>

</body>
</html>
