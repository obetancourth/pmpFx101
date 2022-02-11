/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Label lblDisplay;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnBackSpace;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnPercent;
    @FXML
    private Button btn0;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnEqual;

    private String valueToProcess = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private Boolean dotPending = false;
    @FXML
    private void btn_onClick(ActionEvent event) {
        Button btnClicked = (Button) event.getSource();
       
        switch (btnClicked.getId()) {
            case "btn1", "btn2", "btn3", "btn4", "btn5", "btn6", "btn7", "btn8", "btn9":
                if (dotPending) {
                    valueToProcess = valueToProcess + ".";
                    dotPending = false;
                }
                valueToProcess = valueToProcess + btnClicked.getText();
                break;
            case "btnDot":
                if (!valueToProcess.contains(".")) {
                    if (valueToProcess.length() == 0) {
                        valueToProcess = "0";
                    }
                    dotPending = true;
                }
                break;
            case "btnBackSpace":
                if (valueToProcess.length() > 0) {
                    valueToProcess = valueToProcess.substring(0, valueToProcess.length() - 1);
                    if ( valueToProcess.endsWith(".")) {
                        valueToProcess = valueToProcess.substring(0, valueToProcess.length() - 1);
                    }
                }
            case "btnClear":
                valueToProcess = "";
                dotPending = false;
                break;
        }
        
        lblDisplay.setText(valueToProcess);
    }
    
}