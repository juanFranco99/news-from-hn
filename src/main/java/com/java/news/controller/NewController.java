package com.java.news.controller;

import com.java.news.model.New;
import com.java.news.service.NewService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewController {

    @Autowired
    private NewService service;

    @RequestMapping
    public List<New> getNews() throws IOException, ParseException {
        return service.getAllJava();
    }

    @RequestMapping("/query/{query}")
    public List<New> getNews(@PathVariable("query") String query) throws IOException, ParseException {
        return service.getByQuery(query);
    }

}
