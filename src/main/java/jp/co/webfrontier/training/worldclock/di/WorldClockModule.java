package jp.co.webfrontier.training.worldclock.di;

import com.google.inject.AbstractModule;

import jp.co.webfrontier.training.worldclock.model.SettingModel;
import jp.co.webfrontier.training.worldclock.model.SettingModelImpl;
import jp.co.webfrontier.training.worldclock.model.WorldClockModel;
import jp.co.webfrontier.training.worldclock.model.WorldClockModelImpl;

public class WorldClockModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SettingModel.class).to(SettingModelImpl.class).asEagerSingleton();
        bind(WorldClockModel.class).to(WorldClockModelImpl.class).asEagerSingleton();
    }
}
