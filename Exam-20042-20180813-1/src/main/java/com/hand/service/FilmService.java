package com.hand.service;

import com.hand.dao.FilmDAO;
import com.hand.pojo.Film;

import java.util.Map;

public class FilmService {
    public Map<String,Object> getAllFilmBypage(int page, int size){
        FilmDAO filmDAO=new FilmDAO();
        Map<String,Object> map=filmDAO.getAllFilmBypage(page,size);
        return  map;
    }
    public  int delFilmByFilmId(int filmId){
        FilmDAO filmDAO=new FilmDAO();
        return  filmDAO.delFilmByFilmId(filmId);
    }
    public   int addFilm(String title,String description,int language_id){
        FilmDAO filmDAO=new FilmDAO();
        return filmDAO.addFilm( title, description, language_id);
    }
    public  int updateFilm(String title,String description,int language_id,int film_id){
        FilmDAO filmDAO=new FilmDAO();
        return filmDAO.updateFilm(title, description, language_id, film_id);
    }
    public Film getFilmById(int film_id){
        FilmDAO filmDAO=new FilmDAO();
        return filmDAO.getFilmById(film_id);
    }
}
