package logreader.util;

public class LogFileParser {

	public String getTimeStamp(String strLine) {
		return strLine.substring(strLine.indexOf("timestamp") + 11, strLine.length() - 1);

	}

	public String getId(String strLine) {
		return strLine.substring(7, strLine.indexOf(",") - 1);
	}
}
