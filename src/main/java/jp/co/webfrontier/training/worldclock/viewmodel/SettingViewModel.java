package jp.co.webfrontier.training.worldclock.viewmodel;

import com.google.inject.Inject;

import de.saxsys.mvvmfx.ViewModel;
import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.TimeFormat;
import jp.co.webfrontier.training.worldclock.model.SettingModel;

public class SettingViewModel implements ViewModel {

	private final SettingModel settingModel;


	@Inject
    public SettingViewModel(SettingModel settingModel) {
    	this.settingModel = settingModel;
    }

	public void setCurrentCity(City newCity) {
		settingModel.setCurrentCity(newCity);
	}

	public City getCurrentCity() {
		return settingModel.getCurrentCity();
	}

	public void setCurrentTimeFormat(boolean isFormat12Hours) {
		if (isFormat12Hours) {
			settingModel.setCurrentTimeFormat12Hours();
		} else {
			settingModel.setCurrentTimeFormat24Hours();
		}
	}

	public boolean isCurrentTimeFormat24Hours() {
		TimeFormat format = settingModel.getCurrentTimeFormat();
		return format.equals(TimeFormat.FORMAT_12_HOURS);
	}
}
