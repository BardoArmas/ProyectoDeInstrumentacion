/*
Parametros necesarios para almacenarlos mientras este la conexion
hacia arduino
 */
package com.app.modelo.entidades;

public class Parametro {
    
    private String puerto;
    private int dato,baudios,paro,paridad;

    public Parametro() {
    }

    public Parametro(String puerto, int baudios, int dato, int paro, int paridad) {
        this.puerto = puerto;
        this.dato = dato;
        this.baudios = baudios;
        this.paro = paro;
        this.paridad = paridad;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getBaudios() {
        return baudios;
    }

    public void setBaudios(int baudios) {
        this.baudios = baudios;
    }

    public int getParo() {
        return paro;
    }

    public void setParo(int paro) {
        this.paro = paro;
    }

    public int getParidad() {
        return paridad;
    }

    public void setParidad(int paridad) {
        this.paridad = paridad;
    }

    @Override
    public String toString() {
        return "Parametro{" + "puerto=" + puerto + ", dato=" + dato + ", baudios=" + baudios + ", paro=" + paro + ", paridad=" + paridad + '}';
    }
    
}
