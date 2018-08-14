package com.hand.dao;

import com.hand.pojo.Film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmDAO {
    public Map<String,Object> getAllFilmBypage(int page,int size){
        Map<String,Object> map=new HashMap<String,Object>();

        int count=0;
        int countPage=0;  //总页数
        List<Film> list=new ArrayList<Film>();

        String sql="select count(*) as a from film";
        count=DBPool.uniqueQuery(sql);




    countPage=count%size==0?count/size:count/size+1;

        //处理边界
        if(page<1)
        {
            page=1;
        }

        if(page>countPage)
        {
            page=countPage;
        }
        Film film=new Film();
        //得到分页的film
        sql="select film_id,title,description,language.name as language,film.language_id as language_id from film,Language where film.language_id=language.language_id and title!='0' limit ?,?";
        list=DBPool.query(film.getClass(),sql, (page-1)*size,size);




        map.put("list", list);
        map.put("page", page);
        map.put("size", size);
        map.put("count", count);
        map.put("countpage", countPage);

        return map;
    }

     public  int delFilmByFilmId(int filmId){
        String delSql="update  film set title='0' where film_id=?";
        int n=0;
              n=  DBPool.ZSG(delSql,filmId);
        return  n;
     }
     public   int addFilm(String title,String description,int language_id){
        String sql="insert into film(title,description,language_id) values(?,?,?)";
        int n=0;
        n=DBPool.ZSG(sql,title,description,language_id);
        return  n;
     }
     public  int updateFilm(String title,String description,int language_id,int film_id){
        String sql="update  film set title=?,description=?,language_id=? where film_id=?";
        int n=0;
        n=DBPool.ZSG(sql,title,description,language_id,film_id);
        return  n;
     }
     public Film getFilmById(int film_id){
        Film film=null;
         String sql="select film_id,title,description,language.name as language,film.language_id as language_id from film,Language where film.language_id=language.language_id and film_id=?";
        List list= DBPool.query(Film.class,sql,film_id);

        return  (Film)list.get(0);
    }

    public static void main(String[] args) {

    }
}
