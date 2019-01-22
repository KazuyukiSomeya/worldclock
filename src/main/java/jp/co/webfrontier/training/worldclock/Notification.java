package jp.co.webfrontier.training.worldclock;

public enum Notification {

	CLOCK_UPDATED("clock-updated"),
	CITY_CHANGED("city-changed"),
	TIME_FORMAT_CHANGED("time-format-changed");

	final private String name;

	Notification(String name) {
		this.name= name;
	}

	public String toString() { return name; };
}
