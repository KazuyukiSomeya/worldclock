package jp.co.webfrontier.training.worldclock.model;

import com.google.inject.ImplementedBy;

import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.TimeFormat;

@ImplementedBy(SettingModelImpl.class)
public interface SettingModel {

	public void setCurrentCity(City newCity);
	public City getCurrentCity();

	public void setCurrentTimeFormat12Hours();
	public void setCurrentTimeFormat24Hours();

	public TimeFormat getCurrentTimeFormat();
}
