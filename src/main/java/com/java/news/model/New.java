package com.java.news.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Data
public class New  implements Serializable {

    public Date created_at;
    public Object title;
    public Object url;
    public String author;
    public Object points;
    public Object story_text;
    public String comment_text;
    public Object num_comments;
    public int story_id;
    public String story_title;
    public String story_url;
    public int parent_id;
    public int created_at_i;
    public ArrayList<String> _tags;
    public String objectID;
    public HighlightResult _highlightResult;
}
