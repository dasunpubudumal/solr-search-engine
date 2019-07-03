package com.realitix.solr_engine.solrengine.beans;

import org.apache.solr.client.solrj.beans.Field;

public class LyricBean {

    @Field("title")
    private String title;
    @Field("artist")
    private String artist;
    @Field("common")
    private Object common;
    @Field("author")
    private String author;
    @Field("lyrics")
    private String lyrics;
    @Field("score")
    private float score;

    public LyricBean() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Object getCommon() {
        return common;
    }

    public void setCommon(Object common) {
        this.common = common;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LyricBean{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", common='" + common + '\'' +
                ", author='" + author + '\'' +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }
}
