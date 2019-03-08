/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.LibraryAPI.services;

import edu.eci.arsw.LibraryAPI.model.Book;
import edu.eci.arsw.LibraryAPI.model.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.el.ELException;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiante
 */
@Service
public class LibraryServices {

    private HashMap<Long, Library> libraries;
    private long idnext;

    public LibraryServices() {
        idnext = 0;
        libraries = new HashMap<Long, Library>();
        Book libro1 = new Book("Bible", "Unknown", "kjfbdskbgdkjbfkdf", 1);
        Book libro2 = new Book("Harry Potter", "JK Rowling", "kjvbdfkjvbd", 2);
        Book libro3 = new Book("Narnia", "CS Lewis", "khbvdsjbgjdfhbv", 3);
        Book libro4 = new Book("Anna Karenina", "Leo Tolstoy", "kfbdbvkdfbvkfbv", 4);
        Book libro5 = new Book("Moby-Dick", "Herman Melville", "dgdjytgthfg", 5);
        Book libro6 = new Book("War and Peace", "Leo Tolstoy", "djbdkfjbgdk", 6);
        Library libreria1 = new Library("Libreria el hilito", "300 400 6734", "p sherman calle wallaby 42 sidney");
        Library libreria2 = new Library("Libreria de la esquina", "318 847 8818", "calle de la esquina");
        Library libreria3 = new Library("Libreria vacia", "312 456 7891", "calle sin casas");
        libreria1.addBook(libro1);
        libreria1.addBook(libro2);
        libreria1.addBook(libro3);
        libreria2.addBook(libro4);
        libreria2.addBook(libro5);
        libreria2.addBook(libro6);
        addALibrary(libreria1);
        addALibrary(libreria2);
        addALibrary(libreria3);
    }

    public void addALibrary(Library library) {
        idnext++;
        libraries.put(idnext, library);
    }

    public void addBookToALibrary(String id, Book book) throws Exception {
        libraries.get(id).addBook(book);
    }

    public Set<Library> getAllLibraries() throws Exception {
        Set<Library> libs = new HashSet<Library>();
        for (Library l : libraries.values()) {
            libs.add(l);
        }
        return libs;
    }

    public Set<Book> getLibraryBooksById(long id) throws Exception {
        try {
            Set<Book> libs = new HashSet<Book>();
            for (Book b : libraries.get(id).getLibros().values()) {
                libs.add(b);
            }
            return libs;
        } catch (NullPointerException e) {
            throw new Exception("No existe la libreria");
        }

    }

    public void deleteLibrary(long id) throws Exception {
        try {
            if (libraries.get(id).getLibros().size() == 0) {
                libraries.remove(id);
            } else {
                throw new Exception("La libreria no está vacia");
            }
        } catch (NullPointerException e) {
            throw new Exception("No existe la libreria");
        }

    }
    
    public void addBooksByLibraryID(long id, Book book) throws Exception{
        try {
            libraries.get(id).addBook(book);
        } catch (NullPointerException e) {
            throw new Exception("No existe la libreria");
        }
    }

}
