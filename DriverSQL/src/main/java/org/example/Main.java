package org.example;

import java.sql.*;

public class Main {

    static String URL = "jdbc:mysql://localhost:3306/testsql";
    static String usuario = "root";
    static String password = "celular1";


    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `testsql`.`peoples`\n" +
                    "(`firstname`)\n" +
                    "VALUES\n" +
                    "('TestesGitHub');");
            stmt.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from peoples");


            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") +" | " + resultSet.getString("firstname"));

            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}