package com.itheima.bean;

import java.io.Serializable;

public class Words implements Serializable {
    private int id;
    private String word;

    public Words() {
    }

    public Words(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
