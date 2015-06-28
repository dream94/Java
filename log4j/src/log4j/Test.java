package log4j;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * Log4j 2 
 * @author Admin
 *
 */
public class Test {
	static Logger logger = LogManager.getLogger(Test.class.getName());
	public static void test(){
		logger.entry();
		logger.trace("trace 1");
		logger.debug("debug 2");
		logger.info("info 3");
		logger.error("error 4");
		logger.exit();
	}
	public static void main(String[] args) {
		test();
	}
}
