/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.javafx101;
import com.pmp.dao.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author obetancourth
 */
public class ClienteAdapter {

    public String getNombres() {
        return nombres.get();
    }

    public void setNombres(String _nombres) {
        this.nombres.set(_nombres);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String _apellidos) {
        this.apellidos.set(_apellidos);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String _email) {
        this.email.set(_email);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String _telefono) {
        this.telefono.set(_telefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String _direccion) {
        this.direccion.set(_direccion);
    }

    public String getOcupacion() {
        return ocupacion.get();
    }

    public void setOcupacion(String _ocupacion) {
        this.ocupacion.set(_ocupacion);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String _genero) {
        this.genero.set(_genero);
    }

    public String getEstadoCivil() {
        return estadoCivil.get();
    }

    public void setEstadoCivil(String _estadoCivil) {
        this.estadoCivil.set(_estadoCivil);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String _estado) {
        this.estado.set(_estado);
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int _id) {
        this.id.set(_id);
    }
    
    private Cliente _cliente;
    public Cliente getCliente() {
        _cliente.setNombres(nombres.get());
        _cliente.setApellidos(apellidos.get()); 
        _cliente.setDireccion(direccion.get());
        _cliente.setEmail(email.get());
        _cliente.setEstado(estado.get());
        _cliente.setEstadoCivil(estadoCivil.get());
        _cliente.setGenero(genero.get());
        _cliente.setOcupacion(ocupacion.get());
        _cliente.setTelefono(telefono.get());
        _cliente.setId(id.get());
        return this._cliente;
    }
    public ClienteAdapter(){
        this._cliente = new Cliente();
        nombres = new SimpleStringProperty("");
        apellidos = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        telefono = new SimpleStringProperty("");
        direccion = new SimpleStringProperty("");
        ocupacion = new SimpleStringProperty("");
        genero = new SimpleStringProperty("");
        estadoCivil = new SimpleStringProperty("");
        estado = new SimpleStringProperty("");
    }
    public ClienteAdapter(Cliente _cliente){
        this._cliente = _cliente;
        nombres = new SimpleStringProperty("");
        apellidos = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        telefono = new SimpleStringProperty("");
        direccion = new SimpleStringProperty("");
        ocupacion = new SimpleStringProperty("");
        genero = new SimpleStringProperty("");
        estadoCivil = new SimpleStringProperty("");
        estado = new SimpleStringProperty("");
        id = new SimpleIntegerProperty(0);
        
        nombres.set(_cliente.getNombres());
        apellidos.set(_cliente.getApellidos());
        email.set(_cliente.getEmail());
        telefono.set(_cliente.getTelefono());
        direccion.set(_cliente.getDireccion());
        ocupacion.set(_cliente.getOcupacion());
        genero.set(_cliente.getGenero());
        estadoCivil.set(_cliente.getEstadoCivil());
        estado.set(_cliente.getEstado());
        id.set(_cliente.getId());
    }
    
    
    private SimpleStringProperty nombres;
    private SimpleStringProperty apellidos;
    private SimpleStringProperty email;
    private SimpleStringProperty telefono;
    private SimpleStringProperty direccion;
    private SimpleStringProperty ocupacion;
    private SimpleStringProperty genero;
    private SimpleStringProperty estadoCivil;
    private SimpleStringProperty estado;
    private SimpleIntegerProperty id;
}
