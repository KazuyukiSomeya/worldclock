package jp.co.webfrontier.training.worldclock.viewmodel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import jp.co.webfrontier.training.worldclock.Notification;
import jp.co.webfrontier.training.worldclock.TimeFormat;
import jp.co.webfrontier.training.worldclock.model.WorldClockModel;

public class WorldClockViewModel implements ViewModel, Runnable {

	static final private DateTimeFormatter twentyFourHoursFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	static final private DateTimeFormatter ampmHoursFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

	private final WorldClockModel worldClockModel;
	private final NotificationCenter notificationCenter;

	private DateTimeFormatter formatter = twentyFourHoursFormatter;

	// 時刻更新用の別スレッド
	private Thread updateThread = null;

    private Logger logger = LoggerFactory.getLogger(WorldClockViewModel.class);

	@Inject
    public WorldClockViewModel(WorldClockModel worldClockModel, NotificationCenter notificationCenter) {
		this.worldClockModel = worldClockModel;
    	this.notificationCenter = notificationCenter;

    	this.notificationCenter.subscribe(Notification.CLOCK_UPDATED.toString(), (key, payload) -> {
    		OffsetDateTime now = (OffsetDateTime)payload[0];
    		notifyClockChanged(now.format(formatter));
    	});

    	this.notificationCenter.subscribe(Notification.TIME_FORMAT_CHANGED.toString(), (key, payload) -> {
    		TimeFormat format = (TimeFormat)payload[0];
    		switch(format) {
    		case FORMAT_12_HOURS:
    			formatter = ampmHoursFormatter;
    			break;
    		case FORMAT_24_HOURS:
    		default:
    			formatter = twentyFourHoursFormatter;
    			break;
    		}

    		logger.debug("時刻表示フォーマットの変更通知を受信: " + formatter.toString());
    	});

		this.updateThread = new Thread(this);
		this.updateThread.start();
    }

	@Override
	public void run() {
		while(updateThread.isAlive()) {
			try {
				Thread.sleep(1000);
				final OffsetDateTime cityTime = worldClockModel.getCityDateTime();
				notifyClockChanged(cityTime.format(formatter));
			} catch (InterruptedException e){
				logger.debug("表示更新スレッドでエラーが発生しました。");
			}
		}
	}

	private void notifyClockChanged(String newClockString) {
		this.publish(Notification.CLOCK_UPDATED.toString(), newClockString);
		logger.debug("時刻の変更を通知: " + newClockString);
	}
}
