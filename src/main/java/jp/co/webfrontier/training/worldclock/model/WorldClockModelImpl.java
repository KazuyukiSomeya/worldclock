package jp.co.webfrontier.training.worldclock.model;

import java.time.Instant;
import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.Notification;

@Singleton
public class WorldClockModelImpl implements WorldClockModel {

	private final NotificationCenter notificationCenter;

	private City city;

    private Logger logger = LoggerFactory.getLogger(WorldClockModelImpl.class);

    @Inject
	public WorldClockModelImpl(SettingModel settingModel, NotificationCenter notificationCenter) {
    	city = settingModel.getCurrentCity();
    	this.notificationCenter = notificationCenter;
    	this.notificationCenter.subscribe(Notification.CITY_CHANGED.toString(), (key, payload) -> {
    		city = (City)payload[0];
			logger.debug("都市の変更通知を受信: " + city.toString());
    	});

        logger.debug("WorldClockModel constructed");
	}

    @Override
    public OffsetDateTime getCityDateTime() {
    	final Instant instant = Instant.now(); // UTC Clock
    	return instant.atOffset(City.getOffsetHours(city));
    }
}
