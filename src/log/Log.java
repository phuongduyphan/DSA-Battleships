package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	public static Logger logger;
	
	public Log(String file_name) {
		try {
			FileHandler handler = new FileHandler(file_name);
			SimpleFormatter formatter = new SimpleFormatter();
			
			handler.setFormatter(formatter);
			logger = Logger.getLogger("");
			logger.addHandler(handler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
