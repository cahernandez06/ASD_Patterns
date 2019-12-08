package model;

public abstract class Catalog {
	protected String title;

	public Catalog(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public abstract void print();

}