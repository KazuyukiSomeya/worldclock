package jp.co.webfrontier.training.worldclock.viewmodel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import de.saxsys.mvvmfx.ViewModel;
import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.Notification;
import jp.co.webfrontier.training.worldclock.TimeFormat;
import jp.co.webfrontier.training.worldclock.model.SettingModel;
import jp.co.webfrontier.training.worldclock.model.WorldClockModel;

public class WorldClockViewModel implements ViewModel, Runnable {

	static final private DateTimeFormatter twentyFourHoursFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	static final private DateTimeFormatter ampmHoursFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

	private final WorldClockModel worldClockModel;
	private final SettingModel settingModel;

	// 時刻更新用の別スレッド
	private Thread updateThread = null;

    private Logger logger = LoggerFactory.getLogger(WorldClockViewModel.class);

	@Inject
    public WorldClockViewModel(WorldClockModel worldClockModel, SettingModel settingModel) {
		this.worldClockModel = worldClockModel;
		this.settingModel = settingModel;

		this.updateThread = new Thread(this);
		this.updateThread.start();
    }

	@Override
	public void run() {
		while(updateThread.isAlive()) {
			try {
				Thread.sleep(1000);
				final City currentCity = settingModel.getCurrentCity();
				final OffsetDateTime cityTime = worldClockModel.getCityDateTime(currentCity);
				final TimeFormat timeFormat = settingModel.getCurrentTimeFormat();
				switch(timeFormat) {
				case FORMAT_12_HOURS:
					notifyClockUpdated(cityTime.format(ampmHoursFormatter));
					break;
				case FORMAT_24_HOURS:
				default:
					notifyClockUpdated(cityTime.format(twentyFourHoursFormatter));
					break;
				}
			} catch (InterruptedException e){
				logger.debug("表示更新スレッドでエラーが発生しました。");
			}
		}
	}

	private void notifyClockUpdated(String newClockString) {
		this.publish(Notification.CLOCK_UPDATED.toString(), newClockString);
		logger.debug("時刻の変更を通知: " + newClockString);
	}
}
