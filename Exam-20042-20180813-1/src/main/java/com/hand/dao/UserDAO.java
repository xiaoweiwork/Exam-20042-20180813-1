package com.hand.dao;

import com.hand.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    public User getUserByName(String name){
         String sql="select first_name from customer where first_name=?";
         List list =DBPool.query(User.class,sql,name);
        User user=(User)list.get(0);
       // System.out.println(name);
     return  user;
    }

    public static void main(String[] args) {
      UserDAO userDAO=new UserDAO();
     User user=userDAO.getUserByName("MARY");
       System.out.println(user.getName());
    }

}
