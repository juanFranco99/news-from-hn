package com.java.news.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class StoryTitle  implements Serializable {
    public String value;
    public String matchLevel;
    public boolean fullyHighlighted;
    public ArrayList<String> matchedWords;
}
