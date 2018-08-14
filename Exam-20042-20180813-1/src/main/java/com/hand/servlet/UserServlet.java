package com.hand.servlet;

import com.hand.pojo.Film;
import com.hand.pojo.User;
import com.hand.service.FilmService;
import com.hand.service.UserService;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet{
    UserService userService=null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String p=request.getParameter("p");
        if("login".equals(p)){
            doLogin(request, response);
        }
    }
    private void doLogin(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        String name=request.getParameter("username");
        userService=new UserService();
        User user=userService.getUserByName(name.trim());
        HttpSession session=request.getSession();
        session.setAttribute("user",user);

        FilmService filmService=new FilmService();
        Map<String,Object> map=filmService.getAllFilmBypage(1,5);
        if(user.getName().equals(name)){

            request.setAttribute("map",map);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }else {

            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }

    public static void main(String[] args) {

    }
}

