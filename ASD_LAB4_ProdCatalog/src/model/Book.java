package model;

public class Book extends Catalog{
	private String isbn;

	public Book(String isbn, String title) {
		super(title);
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public void print(){
		System.out.println("Book [isbn=" + isbn + ", title=" + title + "]");
	}

}