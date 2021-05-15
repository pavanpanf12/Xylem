package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {
	public String userDir = System.getProperty("user.dir");
	FileInputStream fis = null;
	public Properties prop = null;
	public String getProperty(String getProperty) {
		String str = null;
		try {
			fis = new FileInputStream(userDir+"\\src\\main\\java\\resources\\prop.properties");
			prop = new Properties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = prop.getProperty(getProperty);
		return str;
	}

}
