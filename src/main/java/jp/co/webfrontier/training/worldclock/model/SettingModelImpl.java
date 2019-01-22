package jp.co.webfrontier.training.worldclock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.TimeFormat;

@Singleton
public class SettingModelImpl implements SettingModel {

	private City currentCity;
	private TimeFormat currentTimeFormat;

    private Logger logger = LoggerFactory.getLogger(SettingModelImpl.class);

	public SettingModelImpl() {
		currentCity = City.TYO;
		currentTimeFormat = TimeFormat.FORMAT_24_HOURS;

        logger.debug("SettingModelのインスタンスが生成されました.");
	}

    @Override
	public void setCurrentCity(City newCity) {
		if(currentCity.equals(newCity)) {
			return;
		}
		currentCity = newCity;
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
	}

    @Override
	public void setCurrentTimeFormat24Hours() {
		if(currentTimeFormat.equals(TimeFormat.FORMAT_24_HOURS)) {
			return;
		}
		currentTimeFormat = TimeFormat.FORMAT_24_HOURS;
	}

    @Override
	public TimeFormat getCurrentTimeFormat() {
		return currentTimeFormat;
	}
}
