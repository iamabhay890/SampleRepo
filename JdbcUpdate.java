package com.intel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        //String qry="alter table intel.emp add column username varchar(15) after EmpName";
        //String qry1="alter table intel.emp add column password varchar(15) after Address";
        String qry2="update intel.emp  set username='himanshu', password='himanshu123' where EmpId=3";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            System.out.println("Connection established");
            stmt=con.createStatement();
            stmt.executeUpdate(qry2);
            //stmt.executeUpdate(qry1);
            System.out.println("Table Updated Successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
