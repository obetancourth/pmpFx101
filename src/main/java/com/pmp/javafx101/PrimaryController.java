package com.pmp.javafx101;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {
    int contador = 0;
    @FXML
    private Button primaryButton;
    @FXML
    private Label labelContador;

    @FXML
    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
        contador += 1;
        labelContador.setText(Integer.toString(contador));
    }
}
