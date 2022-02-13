package logreader;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logreader.dao.SaveEvent;
import logreader.model.LogEvent;

public class EventProcessor {

	private final static Logger logger = LogManager.getLogger(EventProcessor.class);
	private SaveEvent saveEvent = new SaveEvent();

	public void processEvent(Map<String, LogEvent> hmap) {

		for (LogEvent event : hmap.values()) {

			logger.info(event);
			
			saveEvent.saveEvents(event);

		}

	}

}
