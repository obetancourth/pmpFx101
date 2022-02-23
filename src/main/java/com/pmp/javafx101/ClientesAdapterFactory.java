/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.javafx101;

import java.util.ArrayList;
import com.pmp.dao.Cliente;
/**
 *
 * @author obetancourth
 */
public class ClientesAdapterFactory {
    
    public static ArrayList<ClienteAdapter> getFromClientArrayList( ArrayList<Cliente> clientes) {
        ArrayList<ClienteAdapter> clientesAdapters = new ArrayList();
        clientes.forEach( (cliente) -> clientesAdapters.add(new ClienteAdapter(cliente)));
        return clientesAdapters;
    }
}
