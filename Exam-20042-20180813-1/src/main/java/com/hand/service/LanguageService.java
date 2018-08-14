package com.hand.service;

import com.hand.dao.LanguageDAO;
import com.hand.pojo.Language;

import java.util.List;

public class LanguageService {
    public List<Language> getAllLanguage(){
        LanguageDAO languageDAO=new LanguageDAO();
        return  languageDAO.getAllLanguage();
    }
}
