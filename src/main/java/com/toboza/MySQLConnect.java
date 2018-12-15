package com.toboza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnect {

    private static final String dbURL = "jdbc:mysql://localhost:3306/baza_testowa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "tomek";
    private static final String password = "tomek";
    private Connection connection;


    private void connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
    }

    private void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getItemBase() {
        List<Item> listaItemow = new ArrayList<>();
        connect();
        try {
            String sql = "SELECT * FROM item";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String refka = resultSet.getString("refka");
                String nazwa = resultSet.getString("nazwa");
                String uom = resultSet.getString("uom");
                double cena = resultSet.getDouble("cena");

                Item tempItem = new Item(id, refka, nazwa, uom, cena);
                listaItemow.add(tempItem);
            }
            statement.close();
            resultSet.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaItemow;
    }

    public void putItem(String owner, Integer item_id, Double qty, Double price) {
        connect();
        try {
            String sql = "INSERT into koszyk (owner,item_id,item_qty,items_value)" +
                    "values ('" + owner + "','" + item_id + "','" + qty + "',' "+ price + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}