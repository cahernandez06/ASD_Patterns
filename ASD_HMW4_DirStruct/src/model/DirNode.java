package model;

public abstract class DirNode {
	protected String name;

	public DirNode(String name) {
		this.name =  name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void print();
	public abstract int computeSize();
}
