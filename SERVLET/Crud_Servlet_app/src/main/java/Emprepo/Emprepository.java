package Emprepo;

import entity.User;

import java.sql.ResultSet;

public interface Emprepository {
    public boolean register(String id,String name,double salary,String address,int age,String email,String gender,String password);
    public int getUniqueid();
    public User verifyCredentials(String uname, String password);
}
