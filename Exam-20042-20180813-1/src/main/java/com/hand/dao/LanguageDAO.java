package com.hand.dao;

import com.hand.pojo.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAO {
    public List<Language> getAllLanguage(){
        List<Language> list =new ArrayList<Language>();
        String sql="select language_id,name from language";
         list=DBPool.query(Language.class,sql);


        return  list;
    }

}
