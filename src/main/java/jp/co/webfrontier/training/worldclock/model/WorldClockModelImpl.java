package jp.co.webfrontier.training.worldclock.model;

import java.time.Instant;
import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

import jp.co.webfrontier.training.worldclock.City;

@Singleton
public class WorldClockModelImpl implements WorldClockModel {

    private Logger logger = LoggerFactory.getLogger(WorldClockModelImpl.class);

	public WorldClockModelImpl() {
		logger.debug("WorldClockModelのインスタンスが生成されました.");
	}

    @Override
    public OffsetDateTime getCityDateTime(City city) {
    	final Instant instant = Instant.now(); // UTC Clock
    	return instant.atOffset(City.getOffsetHours(city));
    }
}
