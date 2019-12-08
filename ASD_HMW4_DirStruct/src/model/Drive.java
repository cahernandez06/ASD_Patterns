package model;

import java.util.ArrayList;
import java.util.Collection;

public class Drive extends DirNode{

	protected Collection<DirNode> dirList = new ArrayList<DirNode>();
	
	public Drive(String name) {
		super(name);
	}
	
	public void addNode(DirNode node){
		dirList.add(node);
	}
	
	@Override
	public void print(){
		System.out.println("- drive " + name);
		for (DirNode dir : dirList){
			dir.print();
		}
	}
	@Override
	public int computeSize() {
		int sizeInBytes=0;
		for (DirNode dir : dirList){
			sizeInBytes+=dir.computeSize();
		}
		return sizeInBytes;
	}
}