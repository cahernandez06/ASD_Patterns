package mum.edu.asd.entity;

public class Low implements FanState{
	CeilingFan fan;
	
	public Low(CeilingFan fan) {
		this.fan=fan;
		System.out.println( "Fan in Low Speed" );
	}

	public void pullgreen() {
	      Medium newstate = new Medium(fan);
	      fan.setState(newstate);
	}
	
	public void pullred() {
	      Off newstate = new Off(fan, false);
	      fan.setState(newstate);
	}
}