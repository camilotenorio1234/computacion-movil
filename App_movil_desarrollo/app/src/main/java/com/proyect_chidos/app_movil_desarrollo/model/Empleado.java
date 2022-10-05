package com.proyect_chidos.app_movil_desarrollo.model;

public class Empleado {
    private String nombre;
    private String apellido;
    private Long ccid;
    private Long num_tel;
    private String email;
    private String password;

    public Empleado() {

    }

    public Empleado(String nombre, String apellido, Long ccid, Long num_tel, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ccid = ccid;
        this.num_tel = num_tel;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCcid() {
        return ccid;
    }

    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }

    public Long getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(Long num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ccid=" + ccid +
                ", num_tel=" + num_tel +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
