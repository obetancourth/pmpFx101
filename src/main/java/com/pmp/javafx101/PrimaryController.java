package com.pmp.javafx101;

import com.pmp.dao.Cliente;
import com.pmp.dao.Clientes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.cell.PropertyValueFactory;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
    enum FormMode {
        INS,
        UPD,
        DEL,
        DSP
    }
    
    @FXML
    private TableView tblClientes;
    @FXML
    private TableColumn clmNombres;
    @FXML
    private TableColumn clmApellidos;
    @FXML
    private TableColumn clmEmail;
    @FXML
    private TableColumn clmTelefono;
    @FXML
    private TableColumn clmEstado;

    private ObservableList<ClienteAdapter> listaDeClientes;
    
    private Clientes clientesModel;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnEliminar;
    
    FormMode mode;
    
    
    private void reloadData(){
        listaDeClientes = FXCollections.observableArrayList(
                ClientesAdapterFactory.getFromClientArrayList(
                        clientesModel.obtenerClientes()
                )
        );
        this.tblClientes.getItems().clear();
        this.tblClientes.getItems().addAll(listaDeClientes);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        clientesModel = new Clientes();
        
        this.clmNombres.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("nombres"));
        this.clmApellidos.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("apellidos"));
        this.clmEmail.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("email"));
        this.clmTelefono.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("telefono"));
        this.clmEstado.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("estado"));

        reloadData();
    }
    
    
    private Cliente loadClienteForm(Cliente cliente) throws IOException {
        try {
            FXMLLoader win = App.getFXMLLoader("clienteform");
            Parent winObject = win.load();
            ClienteformController clientesWin = (ClienteformController) win.getController();
            clientesWin.setClienteObject(cliente);
            clientesWin.setMode(mode.name());
            App.loadFXMLModal(winObject);
            if (clientesWin.isConfirmAction()){
                return clientesWin.getClienteObject();
            }
            return null;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
                
    }
    
    @FXML
    private void btnNuevo_click(ActionEvent event) {
        try {
            mode = FormMode.INS;
            Cliente formData = loadClienteForm(new Cliente());
            if (formData != null) {
                clientesModel.agregarCliente(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEditar_click(ActionEvent event) {
         try {
            mode = FormMode.UPD;
            Cliente formData = loadClienteForm(
                    ((ClienteAdapter)tblClientes
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getCliente()
            );
            if (formData != null) {
                clientesModel.actualizarCliente(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnMostrar_click(ActionEvent event) {
        try {
            mode = FormMode.DSP;
            Cliente formData = loadClienteForm(
                    ((ClienteAdapter)tblClientes
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getCliente()
            );
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEliminar_click(ActionEvent event) {
        try {
            mode = FormMode.DEL;
            Cliente formData = loadClienteForm(
                    ((ClienteAdapter)tblClientes
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getCliente()
            );
            if (formData != null) {
                clientesModel.deleteCliente(formData.getId());
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
