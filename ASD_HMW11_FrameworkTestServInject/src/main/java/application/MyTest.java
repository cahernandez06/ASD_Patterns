package application;

import framework.Before;
import framework.Inject;
import framework.Test;
import framework.TestClass;
import static framework.Asserts.*;

@TestClass
public class MyTest {
	@Inject
	Calculator calculator;
	
	@Before
	public void init() {
		System.out.println("perform calc initialization");
		calculator.reset();
	}
	
	@Test
	public void testMethod1() {
		System.out.println("perform test method 1");
		assertEquals(calculator.add(3),3);
		assertEquals(calculator.add(5),7);
	}

	@Test
	public void testMethod2() {
		System.out.println("perform test method 2");
		assertEquals(calculator.add(3),3);
		assertEquals(calculator.substract(6),-1);
	}

}
