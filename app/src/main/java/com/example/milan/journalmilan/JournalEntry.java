package com.example.milan.journalmilan;

import java.io.Serializable;

public class JournalEntry implements Serializable {

    private String Title, Content, Mood;

    public JournalEntry(String title, String content, String mood) {
        Title = title;
        Content = content;
        Mood = mood;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public String getMood() {
        return Mood;
    }

}
