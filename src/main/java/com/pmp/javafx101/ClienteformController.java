/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;

import com.pmp.dao.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private ComboBox<String> cmbEstado;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    
    private boolean confirmAction = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbEstado.getItems().addAll("Activo", "Inactivo");
    }    
    
    @FXML
    private void btnConfirmar_click(ActionEvent event) {
        this.confirmAction = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        this.confirmAction = false;
        App.closeModal(event);
    }
    
    private Cliente _cliente;
    public void setClienteObject( Cliente cliente) {
        _cliente = cliente;
        refreshUX();
    }
    private void refreshUX(){
        txtNombres.setText(_cliente.getNombres());
        txtApellidos.setText(_cliente.getApellidos());
        txtEmail.setText(_cliente.getEmail());
        txtTelefono.setText(_cliente.getTelefono());
        txtDireccion.setText(_cliente.getDireccion());
        txtOcupacion.setText(_cliente.getOcupacion());
        boolean generoIsM = _cliente.getGenero().equals("M");
        rdbGeneroMasculino.setSelected(generoIsM);
        rdbGeneroFemenino.setSelected(!generoIsM);
        
        /*
        if (_cliente.getGenero() == "M") {
            rdbGeneroMasculino.setSelected(true);
            rdbGeneroFemenino.setSelected(false);
        } else {
            rdbGeneroMasculino.setSelected(false);
            rdbGeneroFemenino.setSelected(true);
        }
        */
        boolean isSoltero = _cliente.getEstadoCivil().equals("S");
        boolean isCasado = _cliente.getEstadoCivil().equals("C");
        boolean isViudo = _cliente.getEstadoCivil().equals("V");
        rdbEstCSoltero.setSelected(isSoltero);
        rdbEstCCasado.setSelected(isCasado);
        rdbEstCViudo.setSelected(isViudo);
        
        cmbEstado.setValue(_cliente.getEstado());
        
        //
        
    }
    
    public void setMode(String mode) {
        switch (mode) {
            case "INS":
            case "UPD":
                break;
            case "DEL", "DSP":
                txtNombres.setEditable(false);
                txtApellidos.setEditable(false);
                txtEmail.setEditable(false);
                txtTelefono.setEditable(false);
                txtDireccion.setEditable(false);
                txtOcupacion.setEditable(false);

                rdbGeneroMasculino.setDisable(true);
                rdbGeneroFemenino.setDisable(true);
                rdbEstCSoltero.setDisable(true);
                rdbEstCCasado.setDisable(true);
                rdbEstCViudo.setDisable(true);
                cmbEstado.setEditable(false);
                cmbEstado.setDisable(true);
                if (mode == "DSP") btnConfirmar.setVisible(false);
                
                break;
            
        }
    }
    
    public Cliente getClienteObject(){
        refreshObjFromUx();
        return _cliente;
    }
    
    private void refreshObjFromUx(){
        _cliente.setNombres(txtNombres.getText());
        _cliente.setApellidos(txtApellidos.getText());
        _cliente.setEmail(txtEmail.getText());
        _cliente.setTelefono(txtTelefono.getText());
        _cliente.setDireccion(txtDireccion.getText());
        _cliente.setOcupacion(txtOcupacion.getText());
        
        _cliente.setGenero(rdbGeneroMasculino.isSelected()?"M":"F");
        _cliente.setEstadoCivil(rdbEstCSoltero.isSelected()?"S":(rdbEstCCasado.isSelected()?"C":"V"));

        _cliente.setEstado(cmbEstado.getValue());
        
    }

    public boolean isConfirmAction() {
        return confirmAction;
    }
}
