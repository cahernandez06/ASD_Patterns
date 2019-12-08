package application;

import model.Book;
import model.Category;
import model.DVD;

public class Application {

	public static void main(String [] args){
		
		Category productCatalog=new Category("ProductCatalog");
		
		Category BookCategory=new Category("BookCategory");
		Category DVDCategory=new Category("DVDCategory");
		
		Category fictionCategory=new Category("Fiction");	
		Category computerBookCategory=new Category("Computer Book Category");
		
		Category drama=new Category("Drama");
		Category action=new Category("Action");
		
		Book book1=new Book("11111", "Stargate");
		Book book2=new Book("22222", "Panama Panama");
		Book book3=new Book("33333", "Design Patterns");
		Book book4=new Book("44444", "Java");
		
		DVD dvd1 = new DVD("Life is Beautiful");
		DVD dvd2 = new DVD("The Pianist");
		DVD dvd3 = new DVD("Avengers");
		DVD dvd4 = new DVD("Fast and Furious");
		
		
		fictionCategory.addItem(book1);
		fictionCategory.addItem(book2);
		
		computerBookCategory.addItem(book3);
		computerBookCategory.addItem(book4);
		
		drama.addItem(dvd1);
		drama.addItem(dvd2);

		action.addItem(dvd3);
		action.addItem(dvd4);
		
		BookCategory.addItem(fictionCategory);
		BookCategory.addItem(computerBookCategory);
		
		DVDCategory.addItem(drama);
		DVDCategory.addItem(action);
		
		productCatalog.addItem(BookCategory);
		productCatalog.addItem(DVDCategory);
		
		productCatalog.print();
	}
}