package com.oop.models;

import java.io.Writer;
import java.util.ArrayList;

public class ProGame extends GameBase {

    public ProGame(
            String title,
            String description,
            String image,
            String url,
            ArrayList<Category> categories) {
        super(title, description, image, url, categories);
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

    @Override
    public void print(Writer out) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }
}
