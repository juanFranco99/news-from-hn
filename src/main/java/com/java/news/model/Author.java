package com.java.news.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Author implements Serializable {
    public String value;
    public String matchLevel;
    public ArrayList<String> matchedWords;
}
