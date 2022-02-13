package logreader.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConfiguration {

	private final static Logger logger = LogManager.getLogger(DatabaseConfiguration.class);

	private static Connection con = null;

	public Connection getConnection() {
		logger.debug("Building connection to HSQL Database.");

		if (con == null) {
			try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				con = DriverManager.getConnection("jdbc:hsqldb:file:event-data/eventDB", "SA", "");

				init(con);
			} catch (SQLException | ClassNotFoundException e) {
				logger.error(e.getMessage());
			}

			return con;
		} else {
			return con;
		}

	}

	public void init(Connection con) throws SQLException {
		PreparedStatement st = con.prepareStatement("CREATE TABLE IF NOT EXISTS \r\n"
				+ "EVENTLOG (id varchar(25), eventDuaration INT, host varchar(25), type varchar(25), alert varchar(25))");
		st.executeUpdate();

	}

}
