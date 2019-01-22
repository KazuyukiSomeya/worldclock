package jp.co.webfrontier.training.worldclock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class WorldWetherModel {

	private final SettingModel settingModel;

    private Logger logger = LoggerFactory.getLogger(WorldWetherModel.class);

    @Inject
	public WorldWetherModel(SettingModel settingModel) {
    	this.settingModel = settingModel;
        logger.debug("WorldClock message");
	}
}
