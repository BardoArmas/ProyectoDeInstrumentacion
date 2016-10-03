
package com.app.modelo.entidades;

public class Usuario {
    
    private int idUsuario;
    private String nombre, paterno,materno;
    private String nickUsuario, contrasenia;
    private String correo;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String paterno, String materno, String nickUsuario, String contrasenia, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.nickUsuario = nickUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public Usuario(String nickUsuario, String contrasenia) {
        this.nickUsuario = nickUsuario;
        this.contrasenia = contrasenia;
        this.nombre = "";
        this.paterno = "";
        this.materno = "";
        this.correo = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String nombreCompleto(){
        return "Usuario: " + nombre + " " + paterno + " " + materno;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", nickUsuario=" + nickUsuario + ", contrasenia=" + contrasenia + ", correo=" + correo + '}';
    }
}
