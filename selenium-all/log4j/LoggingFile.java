package log4j;
//20-150
// Running different classes with the same log/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFile {
    private static Logger log = LogManager.getLogger(LoggingFile.class.getName());
    /**
     * Debug
     * Info
     * Warn
     * Error
     * Fatal
     * @param args
     */

    public static void main(String[] args){
        log.trace("Trace Message Logged");
        log.debug("Debug Message Logged");
        log.info("Info Message Logged");
        log.error("Error Message Logged");
        log.fatal("Fatal Message Logged");
    }

    public static void runMethod(){
        log.info("This is from runMethod");
    }

}
