package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test1 {
	private static Logger logger = LogManager.getLogger(Test1.class.getName());
	public static void test(){
		logger.entry();
		logger.trace("trace 1");
		logger.debug("debug 2");
		logger.info("info 3");
		logger.error("error 4");
		logger.exit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		
	}

}
