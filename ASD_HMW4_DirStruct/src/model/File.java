package model;

public class File extends DirNode{
	private int sizeInBytes;
	
	public File(String name, int sizeInBytes) {
		super(name);
		this.sizeInBytes=sizeInBytes;
	}
	
	@Override
	public void print(){
		System.out.println("--- file "+name+" size="+computeSize()+" bytes");
	}

	@Override
	public int computeSize() {
		return sizeInBytes;
	}
}