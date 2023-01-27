package com.example.FireHouse.service;

import com.example.FireHouse.entity.BookMark;
import java.util.List;

public interface BookMarkService {
    public List<BookMark> getBookMarkData();

    public List<BookMark> getBookMarkDataLoading();

    String deleteBookMark(int id);

}
