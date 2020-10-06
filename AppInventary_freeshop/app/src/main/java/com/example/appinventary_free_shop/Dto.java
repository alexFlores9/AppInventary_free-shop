package com.example.appinventary_free_shop;

import java.io.Serializable;

public class Dto implements Serializable {
    int id_producto, categoria, estado_producto;
    String nom_producto,des_producto,unidad_de_medida;
    double stock,precio;

    int id_categoria, estado_categoria;
    String nom_categoria;

    int id_usuario,tipo,estado;
    String nombre,apellido,correo,usuario,clave,pregunta, respuesta;

    public Dto() {

    }

    public Dto(int id_producto, int categoria, String nom_producto, String des_producto, String unidad_de_medida, double stock, double precio, int id_categoria, int estado_categoria, String nom_categoria,int estado_producto, int id_usuario, int tipo, int estado, String nombre, String apellido, String correo, String usuario, String clave, String pregunta, String respuesta) {
        this.id_producto = id_producto;
        this.categoria = categoria;
        this.nom_producto = nom_producto;
        this.des_producto = des_producto;
        this.unidad_de_medida = unidad_de_medida;
        this.stock = stock;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.estado_categoria = estado_categoria;
        this.nom_categoria = nom_categoria;
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.estado_categoria= estado_categoria;
    }

    public Dto(int id_producto,String nom_producto,  String des_producto,  double stock,  double precio, String unidad_de_medida, int estado_producto,int categoria) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.des_producto = des_producto;
        this.stock = stock;
        this.precio = precio;
        this.unidad_de_medida = unidad_de_medida;
        this.estado_producto = estado_producto;



        this.categoria = categoria;


    }


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getDes_producto() {
        return des_producto;
    }

    public void setDes_producto(String des_producto) {
        this.des_producto = des_producto;
    }

    public String getUnidad_de_medida() {
        return unidad_de_medida;
    }

    public void setUnidad_de_medida(String unidad_de_medida) {
        this.unidad_de_medida = unidad_de_medida;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getEstado_categoria() {
        return estado_categoria;
    }

    public void setEstado_categoria(int estado_categoria) {
        this.estado_categoria = estado_categoria;
    }

    public String getNom_categoria() {
        return nom_categoria;
    }

    public void setNom_categoria(String nom_categoria) {
        this.nom_categoria = nom_categoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(int estado_producto) {
        this.estado_producto = estado_producto;
    }
}
