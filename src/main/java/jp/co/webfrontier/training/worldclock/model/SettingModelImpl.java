package jp.co.webfrontier.training.worldclock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.Notification;
import jp.co.webfrontier.training.worldclock.TimeFormat;

@Singleton
public class SettingModelImpl implements SettingModel {

	private final NotificationCenter notificationCenter;

	private City currentCity = City.TYO;
	private TimeFormat currentTimeFormat = TimeFormat.FORMAT_24_HOURS;

    private Logger logger = LoggerFactory.getLogger(SettingModelImpl.class);

	@Inject
	public SettingModelImpl(NotificationCenter notificationCenter) {
		this.notificationCenter = notificationCenter;

        notifyCityChanged();
        notifyTimeFormatChanged();

        logger.debug("SettingModel constructed.");
	}

	private void notifyCityChanged() {
		notificationCenter.publish(Notification.CITY_CHANGED.toString(), currentCity);
	}

	private void notifyTimeFormatChanged() {
		notificationCenter.publish(Notification.TIME_FORMAT_CHANGED.toString(), currentTimeFormat);
	}

    @Override
	public void setCurrentCity(City newCity) {
		if(currentCity.equals(newCity)) {
			return;
		}
		currentCity = newCity;
		notifyCityChanged();
	}

    @Override
	public City getCurrentCity() {
		return currentCity;
	}

    @Override
	public void setCurrentTimeFormat12Hours() {
		if(currentTimeFormat.equals(TimeFormat.FORMAT_12_HOURS)) {
			return;
		}
		currentTimeFormat = TimeFormat.FORMAT_12_HOURS;
		notifyTimeFormatChanged();
	}

    @Override
	public void setCurrentTimeFormat24Hours() {
		if(currentTimeFormat.equals(TimeFormat.FORMAT_24_HOURS)) {
			return;
		}
		currentTimeFormat = TimeFormat.FORMAT_24_HOURS;
		notifyTimeFormatChanged();
	}

    @Override
	public TimeFormat getCurrentTimeFormat() {
		return currentTimeFormat;
	}
}
