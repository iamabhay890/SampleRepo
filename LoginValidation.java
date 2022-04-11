package com.intel;

import java.sql.*;
import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String qry="select EmpName from intel.emp where username=? and password=?";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter UserName");
        String username=sc.next();
        System.out.println("Enter Password");
        String password= sc.next();
        sc.close();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            pstmt=con.prepareStatement(qry);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if(rs.next()){
                String name=rs.getString("EmpName");
                System.out.println("Welcome "+name);
            }
            else{
                System.err.println("Invalid Credentials");
            }
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
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
