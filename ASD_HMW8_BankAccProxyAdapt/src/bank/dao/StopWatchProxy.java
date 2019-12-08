package bank.dao;

import java.lang.reflect.*;

public class StopWatchProxy implements InvocationHandler{
	
	private Object target;
	
	public StopWatchProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		//invoke the method on the target
		Object returnValue = method.invoke(target, args);
		
		stopwatch.stop();
		System.out.println("The metod " + method.getName() + " took " + stopwatch.timeElapsed() + " ms\n");
		return returnValue;
	}
	
}
