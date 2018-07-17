package Logging;

/**
 * Created by williamguan on 2018/7/17.
 */
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Logging {
    public static void info(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.INFO, msg, null);
    }
    public static void debug(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.DEBUG, msg, null);
    }
    public static void error(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.ERROR, msg, null);
    }
    public static void warn(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.WARN, msg, null);
    }
    public static void fatal(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.FATAL, msg, null);
    }
    public static void trace(Object msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        Logger logger = Logger.getLogger(stack[1].getClassName());
        logger.log(Logging.class.getName(), Level.TRACE, msg, null);
    }

}
