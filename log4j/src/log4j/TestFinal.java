package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestFinal {
	private Logger logger = LogManager.getLogger(TestFinal.class.getName());
	
	public void writeFile(){
		for(int t=0; t<100000; ++t){
			logger.debug("123");
		}
	}
	public static void main(String[] args) {
		new TestFinal().writeFile();
	}
}
