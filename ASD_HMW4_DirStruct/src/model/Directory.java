package model;

import java.util.ArrayList;
import java.util.Collection;

public class Directory extends DirNode{
	
	protected Collection<DirNode> dirList = new ArrayList<DirNode>();
	
	public Directory(String name) {
		super(name);
	}
	
	public void addNode(DirNode node){
		dirList.add(node);
	}
	
	@Override
	public void print(){
		System.out.println("-- dir "+name+" size="+computeSize()+" bytes");
		for (DirNode dir : dirList){
			dir.print();
		}
	}

	@Override
	public int computeSize() {
		int sizeInBytes=0;
		for (DirNode node : dirList){
			sizeInBytes+=node.computeSize();
		}
		return sizeInBytes;
		}
}
