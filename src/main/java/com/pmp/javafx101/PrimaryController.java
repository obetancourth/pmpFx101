package com.pmp.javafx101;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.pmp.dao.Cliente;

public class PrimaryController {
    int contador = 0;
    @FXML
    private Button primaryButton;
    @FXML
    private Label labelContador;

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
        //App.loadFXML(winObject);
        } catch (IOException ex) {
            System.err.println(ex);
        }
                
    }
}
