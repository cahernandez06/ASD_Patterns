package framework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

//	private static List<Object> objectMapServices = new ArrayList<>();
	private static List<Object> objectMap = new ArrayList<>();

	@SuppressWarnings("deprecation")
	public FWContext() {
		try {
			// find and instantiate all classes annotated with the @Service annotation
			Reflections reflections = new Reflections("");
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> implementationClass : types) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// find and instantiate all classes annotated with the @TestClass annotation
			Reflections reflections = new Reflections("");
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> implementationClass : types) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Perform dependency injection
		performDI();
	}
	
	private void performDI() {
		try {
			//For all instances in the objectMap
			for (Object theTestClass : objectMap) {
				// For all fields of each objects
				for (Field field : theTestClass.getClass().getDeclaredFields()) {
					//If that field is annotated with @Inject
					if (field.isAnnotationPresent(Inject.class)) {
						// get the type of the field
						Class<?> theFieldType = field.getType();
						// Search for an object instance of this type
						Object instance = getBeanOftype(theFieldType);
						// Do the injection: field -> bean
						field.setAccessible(true);
						field.set(theTestClass, instance);
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Object getBeanOftype(Class interfaceClass) {
		Object service = null;
		try {
			for (Object theTestClass : objectMap) {
				Class<?>[] interfaces = theTestClass.getClass().getInterfaces();
				
				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName()))
						service = theTestClass;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	public void start() {
		Method methodBefore = null;
		
		try {
			//For all instances in objectMap
			for (Object theTestClass : objectMap) {
				// Find methods annotated with the @Before annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					//If there is a method anotated with @Before, save it in a temp var
					if (method.isAnnotationPresent(Before.class)) {
						methodBefore = method;
						break;

					}
				}				
				// find all methods annotated with the @Test annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					//If there is a method annotated with Test, then execute the before Method and later the test method
					if (method.isAnnotationPresent(Test.class)) {
						//First invoke the Before method to initialize
						methodBefore.invoke(theTestClass);
						//After initialize, invoke each Test Method
						method.invoke(theTestClass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
