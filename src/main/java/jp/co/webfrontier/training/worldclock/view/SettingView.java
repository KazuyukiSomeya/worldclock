package jp.co.webfrontier.training.worldclock.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Window;
import jp.co.webfrontier.training.worldclock.City;
import jp.co.webfrontier.training.worldclock.viewmodel.SettingViewModel;

public class SettingView implements FxmlView<SettingViewModel>, Initializable {

	@FXML
	ChoiceBox<City> cityChoiceBox;

	@FXML
	CheckBox clockFormat12HoursCheckBox;

	@FXML
	Button applyButton;

	@FXML
	Button cancelButton;

    @InjectViewModel
    private SettingViewModel viewModel;

    private Logger logger = LoggerFactory.getLogger(SettingView.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	ObservableList<City> list
        = FXCollections.observableArrayList(City.values());

    	cityChoiceBox.getItems().addAll(list);
        cityChoiceBox.setValue(viewModel.getCurrentCity());
        clockFormat12HoursCheckBox.setSelected(viewModel.isCurrentTimeFormat24Hours());
    }

    @FXML
    private void apply(ActionEvent event) {
    	logger.debug("設定ボタンが押された");
    	viewModel.setCurrentCity(cityChoiceBox.getValue());
    	viewModel.setCurrentTimeFormat(clockFormat12HoursCheckBox.isSelected());
        final Window window = applyButton.getScene().getWindow();
        window.hide();
    }

    @FXML
    private void cancel(ActionEvent event) {
    	logger.debug("キャンセルボタンが押された");

        final Window window = cancelButton.getScene().getWindow();
        window.hide();
    }

}
