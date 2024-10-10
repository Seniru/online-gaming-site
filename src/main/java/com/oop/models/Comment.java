package com.oop.models;

import java.io.Writer;

public class Comment implements Persistable, Printable {

    private int commentID;
    private String gtitle;
    private String body;

    public Comment(int commentID, String gtitle, String body) {

        this.catommentID = commentID;
        this.gtitle = gtitle;
        this.body = body;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public void print(Writer out) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

    @Override
    public void load() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
