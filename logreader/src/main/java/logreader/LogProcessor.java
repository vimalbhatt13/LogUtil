package logreader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import logreader.model.LogEvent;
import logreader.util.LogFileParser;

public class LogProcessor {

	private final static Logger logger = LogManager.getLogger(LogProcessor.class);

	private LogFileParser parser = new LogFileParser();
	Map<String, LogEvent> hmap = new ConcurrentHashMap<>();

	public Map<String, LogEvent> processLogFile(String filePath) {
		try {
			logger.info("Processing the file.");
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;

			while ((strLine = br.readLine()) != null) {

				ObjectMapper mapper = new ObjectMapper();
				LogEvent event = mapper.readValue(strLine, LogEvent.class);

				String key = parser.getId(strLine);

				if (hmap.containsKey(key)) {

					long endTime = Long.parseLong(event.getTimestamp());
					long startTime = Long.parseLong(hmap.get(key).getTimestamp());
					hmap.get(key).setEventDuaration(endTime - startTime);

					if (endTime - startTime > 4) {
						logger.warn("Event {} has taken more than 4 ms to get processed : ", key);
						hmap.get(key).setAlert("YES");

					} else {
						hmap.get(key).setAlert("NO");
					}
				} else {
					hmap.put(key, event);
				}

			}
			fstream.close();

		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
		}
		return hmap;
	}

}
