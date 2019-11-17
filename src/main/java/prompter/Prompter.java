package prompter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prompter {
	
	private Logger logger = Logger.getAnonymousLogger();
	
	private FileHandler fileHandler;
	
	private Formatter formatter;
	
	public Prompter() throws IOException {
		 formatter = new CustoFormatter();
		 fileHandler = new FileHandler("logs.txt", Boolean.FALSE);
		 fileHandler.setFormatter(formatter);
		 
		 logger.setLevel(Level.INFO);
		 logger.addHandler(fileHandler);
	}
	
	public void log(String message){
		logger.log(Level.INFO,message);
		System.out.println(message);
	}
	
	public void close(){
		fileHandler.close();
	}

}
