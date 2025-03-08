package com.example.crudfirebase;

public class Clientes {
    private String Apellido;
    private String Direccion;
    private String Nombre;
    private String Correo;
    private String Dni;
    private String Telefono;
    private String Id;

    public Clientes(String apellido, String direccion, String nombre, String correo, String dni, String telefono, String id) {
        Apellido = apellido;
        Direccion = direccion;
        Nombre = nombre;
        Correo = correo;
        Dni = dni;
        Telefono = telefono;
        Id = id;
    }

    public Clientes(){

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
