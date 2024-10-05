package com.oop.models;

import java.util.ArrayList;

public abstract class GameBase implements Persistable, Printable {

  protected String title;
  protected String description;
  protected String image;
  protected String url;
  protected ArrayList<Category> categories;

  public GameBase(
      String title, String description, String image, String url, ArrayList<Category> categories) {
    this.title = title;
    this.description = description;
    this.image = image;
    this.url = url;
    this.categories = categories;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getUrl() {
    return url;
  }

  public void setURl(String url) {
    this.url = url;
  }

  public ArrayList<Category> getCategories() {
    return categories;
  }

  public void setCategories(ArrayList<Category> categories) {
    this.categories = categories;
  }
}
