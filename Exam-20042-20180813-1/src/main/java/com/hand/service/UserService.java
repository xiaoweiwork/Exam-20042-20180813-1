package com.hand.service;

import com.hand.dao.UserDAO;
import com.hand.pojo.User;

import javax.xml.ws.ServiceMode;


public class UserService {
    public User getUserByName(String name){
      //  System.out.println("jinlaile");
        UserDAO userDAO=new UserDAO();
        User user=userDAO.getUserByName(name);
      //  System.out.println(user.getName());
        return user;
    }

    public static void main(String[] args) {
        UserService userService=new UserService();
        User user=userService.getUserByName("MARY");
        System.out.println(user.getName());
    }
}
