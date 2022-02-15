/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;

import java.net.URL;
import java.util.ResourceBundle;
iimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
mport javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class ClienteformController implements Initializable {


    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtOcupacion;
    @FXML
    private RadioButton rdbGeneroFemenino;
    @FXML
    private ToggleGroup genero;
    @FXML
    private RadioButton rdbGeneroMasculino;
    @FXML
    private RadioButton rdbEstCSoltero;
    @FXML
    private ToggleGroup estadoCivil;
    @FXML
    private RadioButton rdbEstCCasado;
    @FXML
    private RadioButton rdbEstCViudo;
    @FXML
    private ComboBox<?> cmbEstado;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnConfirmar_click(ActionEvent event) {
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
    }

}
