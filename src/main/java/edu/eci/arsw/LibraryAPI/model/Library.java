/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.LibraryAPI.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author estudiante
 */
public class Library {
    private String nombre, telefono, direccion;
    private long ID;
    private HashMap<Long,Book> libros;
    
    public Library(String nombre, String telefono, String direccion){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        libros = new HashMap<Long,Book>();
    }
    
    public void addBook(Book b){
        long id = b.getID();
        if(!libros.containsKey(id)){
            libros.put(id, b);
        }
    }

    public HashMap<Long, Book> getLibros() {
        return libros;
    }

    public void setLibros(HashMap<Long, Book> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getID() {
        return ID;
    }
}
