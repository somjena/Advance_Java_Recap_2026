package org.codecomrades.Service;
import com.mysql.cj.protocol.Resultset;
import org.codecomrades.Entity.Emp;
import org.codecomrades.Repository.EmpRepo;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class EmpServices implements EmpRepo {
private static Connection con;
private static Scanner sc = new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/emp";
    static String user = "root";
    static String password = "root1234";
Emp e = new Emp();
static {
    try {
       con =  DriverManager.getConnection(url,user,password);
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}


    @Override
    public boolean register()  {
        System.out.println("Enter the Employee Id");
        e.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the Employee Name");

        e.setName(sc.nextLine());
        System.out.println("Enter the Employee Salary");
        e.setSalary(sc.nextDouble());
        System.out.println("Enter the Employee Adress");
        sc.nextLine();
        e.setAdress(sc.nextLine());

        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement("insert into emp_data values(?,?,?,?)");
            pr.setInt(1,e.getId());
            pr.setString(2,e.getName());
            pr.setDouble(3,e.getSalary());
            pr.setString(4,e.getAdress());
            int rows = pr.executeUpdate();
            if (rows>0){
                System.out.println("Employee Registered Successfully ✅");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean updateEmp() {
        System.out.println("Enter the Employee id You Want to Update");
        int id = sc.nextInt();
        String sql = "select * from emp_data where id = ?";
        try {
           PreparedStatement pr = con.prepareStatement(sql);
           pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                System.out.println("Yes "+name+ " Tell Me What You want to Update");
                System.out.println("1.Name\n2.Address");
                int val = sc.nextInt();
                switch (val){
                    case 1 :
                        System.out.println("Enter Your Updated Name");
                        sc.nextLine();
                        String uname = sc.nextLine();

                        PreparedStatement prn = con.prepareStatement("update emp_data set name = ? where id = ?");
                            prn.setString(1,uname);
                            prn.setInt(2,rs.getInt("id"));
                        //System.out.println(rs.getInt("id"));
                            int urows = prn.executeUpdate();
                            if (urows>0){
                                System.out.println("Your Name Updated to "+ uname);
                            }
                            break;
                    case 2 :
                        System.out.println("Enter the Address You want to Update");
                        sc.nextLine();
                        e.setAdress(sc.nextLine());
                        PreparedStatement pra = con.prepareStatement("update emp_data set adress = ? where id =?");
                        pra.setString(1,e.getAdress());
                        pra.setInt(2,rs.getInt("id"));
                        int radr = pra.executeUpdate();
                        if(radr>0){
                            System.out.println("Adress Updated Successfully to" + e.getAdress());
                        }else{
                            System.out.println("Issue to Update Address");
                        }
                        break;

                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println();


        return false;
    }

    @Override
    public boolean deleteEmp() {
        return false;
    }
}
