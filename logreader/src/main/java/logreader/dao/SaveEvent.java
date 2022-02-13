package logreader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logreader.config.DatabaseConfiguration;
import logreader.model.LogEvent;

public class SaveEvent {
	private DatabaseConfiguration config = new DatabaseConfiguration();
	private final static Logger logger = LogManager.getLogger(SaveEvent.class);

	public void saveEvents(LogEvent event) {

		String sql = "INSERT INTO EVENTLOG VALUES (?,?,?,?,?)";
		Connection conn = config.getConnection();
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, event.getId());
			st.setLong(2, event.getEventDuaration());
			st.setString(3, event.getHost());
			st.setString(4, event.getType());
			st.setString(5, event.getAlert());

			int result = st.executeUpdate();

			if (result > 0) {
				logger.debug(event.getId() + " Event inserted into database");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}
}
