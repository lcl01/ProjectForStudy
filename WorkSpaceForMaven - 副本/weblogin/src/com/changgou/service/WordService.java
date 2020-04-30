package com.itheima.service;

import com.itheima.bean.Words;
import com.itheima.dao.WordDao;

import java.util.List;

public class WordService {
    public List<Words> findByKeyWord(String keyword) throws Exception {
        WordDao wordDao = new WordDao();
        List<Words> words=wordDao.findByKeyWord(keyword);
        return words;
    }
}
