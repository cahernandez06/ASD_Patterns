package model;

public class DVD extends Catalog{


	public DVD(String title) {
		super(title);
	}

	@Override
	public void print(){
		System.out.println("DVD [title=" + title +  "]");
	}
}