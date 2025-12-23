package org.codecomrades;

import java.sql.*;

public class CrudManager {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("1.Loading the Driver Class");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root1234";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        //String sql = "insert into student values(1,'som',6371326)";
       // boolean bl = st.execute(sql);
       // System.out.println(bl);
        ResultSet rs = st.executeQuery("select * from student");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String num = rs.getString(3);
            System.out.println("1."+id+"2. "+name + "3. "+num);
        }

    }
}

