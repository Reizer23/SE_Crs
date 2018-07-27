package log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingConsole {
    private static Logger log = LogManager.getLogger(LoggingConsole.class.getName());
    /**
     * Debug
     * Info
     * Warn
     * Error
     * Fatal
     * @param args
     */

    public static void main(String[] args){
        log.debug("Debug Message Logged");
        log.error("Error Message Logged");
        log.fatal("Fatal Message Logged");
    }

}
