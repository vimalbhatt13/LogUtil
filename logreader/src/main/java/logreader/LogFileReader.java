package logreader;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logreader.model.LogEvent;

public class LogFileReader {
	private final static Logger logger = LogManager.getLogger(LogFileReader.class);

	public static void main(String[] args) {
		LogProcessor processor = new LogProcessor();
		EventProcessor eventProcessor = new EventProcessor();

		String path = args[0];

		logger.info("Reading the Log file : {}", path);

		Map<String, LogEvent> hmap = processor.processLogFile(path);
		eventProcessor.processEvent(hmap);

	}
}
