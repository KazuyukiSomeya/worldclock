package jp.co.webfrontier.training.worldclock.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jp.co.webfrontier.training.worldclock.Notification;
import jp.co.webfrontier.training.worldclock.viewmodel.SettingViewModel;
import jp.co.webfrontier.training.worldclock.viewmodel.WorldClockViewModel;

public class WorldClockView implements FxmlView<WorldClockViewModel>, Initializable {
    @FXML
    private Label clockLabel;

    @InjectViewModel
    private WorldClockViewModel viewModel;

    private Logger logger = LoggerFactory.getLogger(WorldClockView.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	viewModel.subscribe(Notification.CLOCK_UPDATED.toString(), (key, payload) -> {
    		final String clockString = (String)payload[0];
    		Platform.runLater(new Runnable() {
				@Override
				public void run() {
					clockLabel.setText(clockString);
				}
    		});

    	});
    }

    public void openSetting() {
		logger.debug("設定画面を開きます");
        ViewTuple<SettingView, SettingViewModel> viewTuple = FluentViewLoader.fxmlView(SettingView.class).load();
        Parent root = viewTuple.getView();
        Stage stage = new Stage();
        stage.setTitle("設定");
        stage.setMinWidth(400);
        stage.setMinWidth(300);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
