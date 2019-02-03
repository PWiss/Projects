package de.hdm_stuttgart.se2_projekt.pascalWiss.data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Class for the Logging
 *
 */
public class MainLog {
	public static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public MainLog(){
		Logger root = Logger.getLogger("");
		
		//FileHandler
		FileHandler errorTxt = null;
		try
		{
			errorTxt = new FileHandler("Errorlog.txt");
		} catch (SecurityException | IOException e)
		{
			
			MainLog.log.severe("Security Error");
			e.printStackTrace();
		}
		//How and what to write in log
		root.setLevel(Level.INFO);
		errorTxt.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record)
			{
				String ret = "";
				if(record.getLevel().intValue() >= Level.WARNING.intValue())
				{
					ret += "ATTENTION!: ";
				}
				ret += record.getLevel();
				SimpleDateFormat df = new SimpleDateFormat(": dd MMM yyyy HH:mm ");
				Date d = new Date(record.getMillis());
				ret += df.format(d);
				
				ret += this.formatMessage(record);
				ret += "\r\n";
				return ret;
			}
		});
		root.addHandler(errorTxt);
	}
	

	


	
}