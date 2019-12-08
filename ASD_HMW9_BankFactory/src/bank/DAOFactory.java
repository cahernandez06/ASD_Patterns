package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DAOFactory {
	
	private MyFactory factory;
//	private String env;

	public DAOFactory() {
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(rootPath + "/config.properties"));
			String environment = prop.getProperty("environment");
			
			if (environment.toUpperCase().equals("PRODUCTION")) {
				this.factory = new ProductionFactory();
//				this.env = environment.toUpperCase();
			} else if (environment.toUpperCase().equals("TEST")){
				this.factory = new MockFactory();
//				this.env = environment.toUpperCase();
			} else {
				System.out.println("The environment property is not correctly configured in config.properties file");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MyFactory getFactory() {
		return this.factory;
	}
}
