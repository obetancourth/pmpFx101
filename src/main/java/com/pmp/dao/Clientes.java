/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

/**
 *
 * @author obetancourth
 */
public class Clientes {
    /*
    private String _nombres;
    private String _apellidos;
    private String _email;
    private String _telefono;
    private String _direccion;
    private String _ocupacion;
    private String _genero;
    private String _estadoCivil;
    private String _estado;
    */
    private Connection _conexion = null;
    
    public Clientes(){
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS clientes"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombres TEXT NOT NULL,"
                + " apellidos TEXT NOT NULL,"
                + " email TEXT NOT NULL,"
                + " telefono TEXT NOT NULL,"
                + " direccion TEXT NOT NULL,"
                + " ocupacion TEXT NOT NULL,"
                + " genero TEXT NOT NULL,"
                + " estadoCivil TEXT NOT NULL,"
                + " estado TEXT NOT NULL);";
        
        try{
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> obtenerClientes () {
        try {
            ArrayList clientes = new ArrayList<Cliente>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM clientes;");
            while (registroEnTabla.next()) {
                Cliente cliente = new Cliente();
                cliente.setId( registroEnTabla.getInt("id") );
                cliente.setNombres( registroEnTabla.getString("nombres"));
                cliente.setApellidos( registroEnTabla.getString("apellidos"));
                cliente.setEmail( registroEnTabla.getString("email"));
                cliente.setTelefono( registroEnTabla.getString("telefono"));
                cliente.setDireccion( registroEnTabla.getString("direccion"));
                cliente.setOcupacion( registroEnTabla.getString("ocupacion"));
                cliente.setGenero( registroEnTabla.getString("genero"));
                cliente.setEstadoCivil( registroEnTabla.getString("estadoCivil"));
                cliente.setEstado( registroEnTabla.getString("estado"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<Cliente>();
        }
    }
    
    public Cliente obtenerCliente (int id) {
        try {
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM clientes where id = ?;");
            comandoSQL.setInt(1, id);
            ResultSet registroEnTabla = comandoSQL.executeQuery();
            Cliente cliente = new Cliente();
            while (registroEnTabla.next()) {
                cliente.setId( registroEnTabla.getInt("id") );
                cliente.setNombres( registroEnTabla.getString("nombres"));
                cliente.setApellidos( registroEnTabla.getString("apellidos"));
                cliente.setEmail( registroEnTabla.getString("email"));
                cliente.setTelefono( registroEnTabla.getString("telefono"));
                cliente.setDireccion( registroEnTabla.getString("direccion"));
                cliente.setOcupacion( registroEnTabla.getString("ocupacion"));
                cliente.setGenero( registroEnTabla.getString("genero"));
                cliente.setEstadoCivil( registroEnTabla.getString("estadoCivil"));
                cliente.setEstado(registroEnTabla.getString("estado"));
                break;
            }
            return cliente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int agregarCliente (Cliente nuevoCliente) {
        try {
            String insertSql = "INSERT INTO clientes (nombres, apellidos, email, telefono, direccion, ocupacion, genero, estadoCivil, estado) values (?, ?, ?, ?, ?, ? ,?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertSql);
            comandoSQL.setString(1, nuevoCliente.getNombres());
            comandoSQL.setString(2, nuevoCliente.getApellidos());
            comandoSQL.setString(3, nuevoCliente.getEmail());
            comandoSQL.setString(4, nuevoCliente.getTelefono());
            comandoSQL.setString(5, nuevoCliente.getDireccion());
            comandoSQL.setString(6, nuevoCliente.getOcupacion());
            comandoSQL.setString(7, nuevoCliente.getGenero());
            comandoSQL.setString(8, nuevoCliente.getEstadoCivil());
            comandoSQL.setString(9, nuevoCliente.getEstado());
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int actualizarCliente (Cliente updateCliente) {
        try {
            String updateSql = "UPDATE clientes SET nombres=?, apellidos=?, email=?, telefono=?, direccion=?, ocupacion=?, genero=?, estadoCivil=?, estado=? where id =?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(updateSql);
            comandoSQL.setString(1, updateCliente.getNombres());
            comandoSQL.setString(2, updateCliente.getApellidos());
            comandoSQL.setString(3, updateCliente.getEmail());
            comandoSQL.setString(4, updateCliente.getTelefono());
            comandoSQL.setString(5, updateCliente.getDireccion());
            comandoSQL.setString(6, updateCliente.getOcupacion());
            comandoSQL.setString(7, updateCliente.getGenero());
            comandoSQL.setString(8, updateCliente.getEstadoCivil());
            comandoSQL.setString(9, updateCliente.getEstado());
            comandoSQL.setInt(10, updateCliente.getId());
            
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int deleteCliente (int id) {
        try {
            String deleteSql = "DELETE FROM clientes where id =?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
            comandoSQL.setInt(1, id);
            
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
   
    
}
