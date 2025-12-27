package org.codecomrades.Driver;
import org.codecomrades.Service.EmpServices;
import java.util.Scanner;

public class EmpDriver {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        EmpServices es = new EmpServices();

        System.out.println("Welcome to Employee Management Application");
        boolean val = true;
        while(val){
            System.out.println("1.Register Employee\n2.Update Employee\n3.Delete Employee");
            int choice = sc.nextInt();
            switch (choice){
                case 1:es.register();
                break;
                case 2 :es.updateEmp();
                break;
                case 3 :es.deleteEmp();
                break;

            }

        }


    }
}
