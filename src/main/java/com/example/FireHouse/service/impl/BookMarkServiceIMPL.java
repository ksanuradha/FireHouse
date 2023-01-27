package com.example.FireHouse.service.impl;

import com.example.FireHouse.entity.BookMark;
import com.example.FireHouse.repo.BookMarkRepo;
import com.example.FireHouse.service.BookMarkService;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookMarkServiceIMPL implements BookMarkService {
    @Autowired
    BookMarkRepo bookMarkRepo;

    @Override
    public List<BookMark> getBookMarkData() {
        try {
            URL url = new URL("http://demo.dreamsquadgroup.com/test/index.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            }
            else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                //Close the scanner
                System.out.println(inline);
                scanner.close();

                JSONParser parser = new JSONParser();
                Object obj  = parser.parse(inline);
                List<BookMark> bookMarks = new ArrayList<BookMark>();

                for(Object data: (JSONArray) obj) {
                    System.out.println(data);
                    BookMark bookMark = new BookMark();
                    bookMark.setImage(((JSONObject) data).get("image").toString());
                    bookMark.setFeatured(Integer.parseInt(((JSONObject) data).get("featured").toString()));
                    bookMark.setUserId(Integer.parseInt(((JSONObject) data).get("user_id").toString()));
                    bookMark.setName(((JSONObject) data).get("name").toString());
                    bookMark.setDescription(((JSONObject) data).get("description").toString());
                    bookMark.setId(Integer.parseInt(((JSONObject) data).get("id").toString()));
                    bookMark.setUrl(((JSONObject) data).get("url").toString());
                    bookMark.setStatus(Integer.parseInt(((JSONObject) data).get("status").toString()));
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                    String expireDateDateInString = ((JSONObject) data).get("expiry_date").toString();
                    String createDateDateInString = ((JSONObject) data).get("expiry_date").toString();
                    bookMark.setExpiryDate(formatter.parse(expireDateDateInString));
                    bookMark.setCreatedAt(formatter.parse(createDateDateInString));
                    bookMarks.add(bookMark);
                }
                bookMarkRepo.saveAll(bookMarks);
                return bookMarks;
            }
        } catch (Exception es) {
            System.out.println(es);
            return null;
        }
    }

    @Override
    public List<BookMark> getBookMarkDataLoading() {
        return bookMarkRepo.findAll();
    }

    @Override
    public String deleteBookMark(int id) {
        BookMark byId = bookMarkRepo.getById(id);
        if (bookMarkRepo.getById(id) != null) {
            bookMarkRepo.deleteById(id);
            return "delete sucess";
        } else {
            return "No Customer Found By ID";
        }
    }
}
