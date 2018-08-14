package com.hand.servlet;

import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.pojo.User;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class FilmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String p=request.getParameter("p");
        if("fengye".equals(p)){
            doGetFilmByPage(request,response);
        }else if ("delete".equals(p)){
            doDelFilm(request,response);
        }else if ("add".equals(p)){
            doAdd(request,response);
        }else  if ("addfilm".equals(p)){
            doAddFilm(request,response);
        }
        else if ("update".equals(p)){
            doUpdateFilm(request,response);
        }else if("updatefilm".equals(p)){
            doUpdate(request,response);
        }

}

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titie=request.getParameter("title");
        String description=request.getParameter("description");
        int language_id=Integer.parseInt(request.getParameter("lan"));
        //int film_id=Integer.parseInt(request.getParameter("film_id"));
        //System.out.println(request.getParameter("lan"));;
        FilmService filmService=new FilmService();

        int n=filmService.updateFilm(titie,description,language_id,1);
        //System.out.println(n);
        request.setAttribute("n",n);
        int page=1;
        int size=5;
       // System.out.println(n);
        PrintWriter pw=response.getWriter();

        if(n>0){
            pw.write("<script> alert('成功！'); </script>");

            Map<String,Object> map=filmService.getAllFilmBypage(page,size);
            request.setAttribute("map",map);
            System.out.println(map);
            request.getRequestDispatcher("main.jsp").forward(request,response);

        }else {
            pw.write("<script> alert('失败！'); </script>");
        }
    }

    private void doUpdateFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=Integer.parseInt(request.getParameter("page"));
        int size=Integer.parseInt(request.getParameter("size"));
        int film_id=Integer.parseInt(request.getParameter("film_id"));
        FilmService filmService=new FilmService();
        Film film=filmService.getFilmById(film_id);
        LanguageService languageService=new LanguageService();
        List list=languageService.getAllLanguage();
        
        request.setAttribute("list",list);
        request.setAttribute("film",film);
         
        request.getRequestDispatcher("updatefilm.jsp").forward(request,response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LanguageService languageService=new LanguageService();
        List list=languageService.getAllLanguage();
        request.setAttribute("list",list);
        request.getRequestDispatcher("addfile.jsp").forward(request,response);
    }

    private void doAddFilm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titie=request.getParameter("title");
        String description=request.getParameter("description");
         int language_id=Integer.parseInt(request.getParameter("lan"));
        //System.out.println(request.getParameter("lan"));;
        FilmService filmService=new FilmService();

        int n=filmService.addFilm(titie,description,language_id);
        int page=1;
        int size=5;
        request.setAttribute("n",n);
       // System.out.println(n);
        PrintWriter pw=response.getWriter();

        if(n>0){
            pw.write("<script> alert('新增成功！'); </script>");

            Map<String,Object> map=filmService.getAllFilmBypage(page,size);
            request.setAttribute("map",map);
            System.out.println(map);
            request.getRequestDispatcher("main.jsp").forward(request,response);

        }else {
            pw.write("<script> alert('失败！'); </script>");
        }
    }

    private void doDelFilm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int page=Integer.parseInt(request.getParameter("page"));
        int size=Integer.parseInt(request.getParameter("size"));
        int film_id=Integer.parseInt(request.getParameter("film_id"));
        //User user=(User)request.getAttribute("user");
        System.out.println(film_id);
        FilmService filmService=new FilmService();
        int n=filmService.delFilmByFilmId(film_id);
        PrintWriter pw=response.getWriter();
        Map<String,Object> map=filmService.getAllFilmBypage(page,size);
        request.setAttribute("n",n);
        request.setAttribute("map",map);
        if(n>0){
            pw.write("<script> alert('删除成功！'); </script>");




            //Map<String,Object> map=filmService.getAllFilmBypage(page,size);
            //FilmService filmService=new FilmService();

            //System.out.println(map);

            request.getRequestDispatcher("main.jsp").forward(request,response);
        }else {
            pw.write("<script> alert('失败！'); </script>");

        }
        pw.flush();
        pw.close();
    }

    private void doGetFilmByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=Integer.parseInt(request.getParameter("page"));
        int size=Integer.parseInt(request.getParameter("size"));
        User user=(User)request.getAttribute("user");
        System.out.println(user);
        FilmService filmService=new FilmService();
        Map<String,Object> map=filmService.getAllFilmBypage(page,size);
        request.setAttribute("map",map);

        request.getRequestDispatcher("main.jsp").forward(request,response);
    }
}
