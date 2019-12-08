package model;

public class Link extends DirNode{
	
	private String pointsTo;
	
	public Link(String name, String pointsTo) {
		super(name);
		this.pointsTo=pointsTo;
	}
	
	public String getPointsTo() {
		return pointsTo;
	}

	public void setPointsTo(String pointsTo) {
		this.pointsTo = pointsTo;
	}

	@Override
	public void print(){
		System.out.println("--- link "+name+" size=0 points to "+getPointsTo());
	}

	@Override
	public int computeSize() {
		return 0;
	}
}
