package com.pmp.javafx101;

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

import javafx.scene.control.cell.PropertyValueFactory;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
    @FXML
    private Button primaryButton;
    @FXML
    private Label labelContador;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.clmNombres.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("nombres"));
        this.clmApellidos.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("apellidos"));
        this.clmEmail.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("email"));
        this.clmTelefono.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("telefono"));
        this.clmEstado.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("estado"));

        listaDeClientes = FXCollections.observableArrayList();
        this.initializeDummyData();
        this.tblClientes.getItems().addAll(listaDeClientes);
    }
    
    private void initializeDummyData() {
        
        Cliente cliente = new Cliente();
        cliente.setNombres("Orlando");
        cliente.setApellidos("Betancourth");
        cliente.setDireccion("Tegucigalpa");
        cliente.setEmail("obetancourthunicah@gmail.com");
        cliente.setGenero("M");
        cliente.setEstadoCivil("C");
        cliente.setOcupacion("Profe");
        cliente.setTelefono("0000-0000");
        ClienteAdapter cadapter = new ClienteAdapter(cliente);
        this.listaDeClientes.add(cadapter);
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        try {
        FXMLLoader win = App.getFXMLLoader("clienteform");
        Parent winObject = win.load();
        ClienteformController clientesWin = (ClienteformController) win.getController();
        // Metodos para Inicializar los datos
        Cliente cliente = new Cliente();
        cliente.setNombres("Orlando");
        cliente.setApellidos("Betancourth");
        cliente.setDireccion("Tegucigalpa");
        cliente.setEmail("obetancourthunicah@gmail.com");
        cliente.setGenero("M");
        cliente.setEstadoCivil("C");
        cliente.setOcupacion("Profe");
        cliente.setTelefono("0000-0000");
        
        clientesWin.setClienteObject(cliente);
        App.loadFXMLModal(winObject);
        cliente = clientesWin.getClienteObject();
        System.out.println(cliente.getString());
        //App.loadFXML(winObject);
        } catch (IOException ex) {
            System.err.println(ex);
        }
                
    }
}
