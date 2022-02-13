package logreader.model;

public class LogEvent {
	private String id;
	private String state;
	private String type;
	private String host;
	private String timestamp;
	private String alert;
	private long eventDuaration;

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public long getEventDuaration() {
		return eventDuaration;
	}

	public void setEventDuaration(long eventDuaration) {
		this.eventDuaration = eventDuaration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "LogEvent [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp="
				+ timestamp + ", alert=" + alert + ", eventDuaration=" + eventDuaration + "]";
	}

	

}
