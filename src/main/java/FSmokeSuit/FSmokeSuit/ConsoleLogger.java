/*package FSmokeSuit.FSmokeSuit;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConsoleLogger {
	
	//DesiredCapabilities caps = DesiredCapabilities.chrome();
	//LoggingPreferences logPrefs = new LoggingPreferences();
    //logPrefs.enable(LogType.BROWSER, Level.ALL);
    //caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    
   // LogEntries logEntries = objWebDriver.manage().logs().get(LogType.BROWSER);
	 //LogEntries logEntries1 = objWebDriver.manage().logs().get(LogType.CLIENT);
	// LogEntries logEntries2 = objWebDriver.manage().logs().get(LogType.DRIVER);
	 //LogEntries logEntries3 = objWebDriver.manage().logs().get(LogType.SERVER);
	 //LogEntries logEntries4 = objWebDriver.manage().logs().get(LogType.PERFORMANCE);
       for (LogEntry entry : logEntries) {
           System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + " " + entry.toString());
       } 

}*/

