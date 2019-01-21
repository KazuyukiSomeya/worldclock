package jp.co.webfrontier.training.worldclock.view;

import java.net.URL;
import java.util.ResourceBundle;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import jp.co.webfrontier.training.worldclock.viewmodel.WorldClockViewModel;

public class WorldClockView implements FxmlView<WorldClockViewModel>, Initializable {
    @FXML
    private Label helloLabel;

    @InjectViewModel
    private WorldClockViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helloLabel.textProperty().bind(viewModel.helloMessageProperty());
    }
}
