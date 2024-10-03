package com.oop.models;

public class GameBase {
	    
		int Title;
	    int description;
	    String image;
	    String URl;

	    
	   
	    public GameBase(int title, int description, String image, String uRl) {
			super();
			Title = title;
			this.description = description;
			this.image = image;
			URl = uRl;
			
		}
		int getTitle() {
			return Title;
		}
		public void setTitle(int title) {
			Title = title;
		}
		public int getDescription() {
			return description;
		}
		public void setDescription(int description) {
			this.description = description;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getURl() {
			return URl;
		}
		public void setURl(String uRl) {
			URl = uRl;
		}
	    
	}

}

