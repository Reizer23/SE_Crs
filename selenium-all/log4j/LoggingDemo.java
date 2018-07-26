package log4j;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
/*import org.apache.logging.log4j.core.appender.AppenderAppender;
import org.apache.logging.log4j.ConsoleAppender;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.PatternLayout;*/

public class LoggingDemo {
    static Logger log ; //("LoggingDemo.class");
    /**
     * Debug
     * Info
     * Warn
     * Error
     * Fatal
     * @param args
     */

    public static void main(String[] args){
        Properties log4jprop = new Properties();
        log4jprop.setProperty("log4j.rootLogger", "DEBUG, CA");
        log4jprop.setProperty("log4j.appender.CA", "orog.apache.log4j.ConsoleAppender");
        log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
        log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%d{yyyy-MM-dd} -- %-10p %c - %m%n");
        //PropertyConfigurator.configure(log4jprop);

        log.info("This message is a info");
        runMethod();
        //log.debug("This message is a debug");
    }

    public static void runMethod(){
        log.info("This is from runMethod");
    }

}
