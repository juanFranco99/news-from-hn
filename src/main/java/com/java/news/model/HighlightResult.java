package com.java.news.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class HighlightResult  implements Serializable {
    public Author author;
    public CommentText comment_text;
    public StoryTitle story_title;
    public StoryUrl story_url;
}
