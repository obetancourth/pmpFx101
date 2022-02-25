/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

/**
 *
 * @author obetancourth
 */
public class Cliente {

    /**
     * @return the _nombres
     */
    public String getNombres() {
        return _nombres;
    }

    /**
     * @param _nombres the _nombres to set
     */
    public void setNombres(String _nombres) {
        this._nombres = _nombres;
    }

    /**
     * @return the _apellidos
     */
    public String getApellidos() {
        return _apellidos;
    }

    /**
     * @param _apellidos the _apellidos to set
     */
    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    /**
     * @return the _email
     */
    public String getEmail() {
        return _email;
    }

    /**
     * @param _email the _email to set
     */
    public void setEmail(String _email) {
        this._email = _email;
    }

    /**
     * @return the _telefono
     */
    public String getTelefono() {
        return _telefono;
    }

    /**
     * @param _telefono the _telefono to set
     */
    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    /**
     * @return the _direccion
     */
    public String getDireccion() {
        return _direccion;
    }

    /**
     * @param _direccion the _direccion to set
     */
    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    /**
     * @return the _ocupacion
     */
    public String getOcupacion() {
        return _ocupacion;
    }

    /**
     * @param _ocupacion the _ocupacion to set
     */
    public void setOcupacion(String _ocupacion) {
        this._ocupacion = _ocupacion;
    }

    /**
     * @return the _genero
     */
    public String getGenero() {
        return _genero;
    }

    /**
     * @param _genero the _genero to set
     */
    public void setGenero(String _genero) {
        this._genero = _genero;
    }

    /**
     * @return the _estadoCivil
     */
    public String getEstadoCivil() {
        return _estadoCivil;
    }

    /**
     * @param _estadoCivil the _estadoCivil to set
     */
    public void setEstadoCivil(String _estadoCivil) {
        this._estadoCivil = _estadoCivil;
    }

    /**
     * @return the _estado
     */
    public String getEstado() {
        return _estado;
    }

    /**
     * @param _estado the _estado to set
     */
    public void setEstado(String _estado) {
        this._estado = _estado;
    }
    
    private String _nombres;
    private String _apellidos;
    private String _email;
    private String _telefono;
    private String _direccion;
    private String _ocupacion;
    private String _genero = "M";
    private String _estadoCivil = "S";
    private String _estado = "Activo";
    private int _id;
    
    
    public String getString(){
        return _nombres + " " + _apellidos; 
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
}
