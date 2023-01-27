package com.example.FireHouse.controller;

import com.example.FireHouse.entity.BookMark;
import com.example.FireHouse.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/bookMark")
@CrossOrigin
public class BookMarksController {

    @Autowired
    BookMarkService bookMarkService;

    @GetMapping(path = "/getAll")
    public List<BookMark> getAllBookMarks() {
        return bookMarkService.getBookMarkData();
    }

    @GetMapping(path = "/getAllBookMarks")
    public List<BookMark> getAllBookMarksAtloading() {
        return bookMarkService.getBookMarkDataLoading();
    }

    @DeleteMapping(path = "/delete-BookMarks/{id}")
    public void deleteBookMark(@PathVariable(value = "id") int id) {
       bookMarkService.deleteBookMark(id);
    }

}
