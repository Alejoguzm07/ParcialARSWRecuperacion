/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.LibraryAPI.model;

/**
 *
 * @author estudiante
 */
public class Book {
    private String nombre, autor, sinopsis;
    private long ID;
    
    public Book(String nombre, String autor,String sinopsis, long ID){
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.ID = ID;                
    }
    
    public Book() {             
    }

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public long getID() {
        return ID;
    }
    
}
