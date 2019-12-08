package mum.edu.asd.entity;

public class Off implements FanState{
	CeilingFan fan;
	
	public Off(CeilingFan fan, boolean start) {
		this.fan=fan;
		if (!start) 
			System.out.println( "Fan Turned Off" );
	}

	public void pullgreen() {
	      Low newstate = new Low(fan);
	      fan.setState(newstate);	      
	}
	
	public void pullred() {
	      High newstate = new High(fan);
	      fan.setState(newstate);
	}
}