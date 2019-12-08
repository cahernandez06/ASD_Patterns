package model;

import java.util.ArrayList;
import java.util.Collection;

public class Category extends Catalog{
    private Collection<Catalog> list = new ArrayList<Catalog>();

	public Category(String title) {
		super(title);
	}

    public void addItem(Catalog item){
    	list.add(item);
    }
    
    @Override
	public void print() {
		System.out.println( "Category name=" + title );
		for (Catalog item : list){
			item.print();
		}
	}
}