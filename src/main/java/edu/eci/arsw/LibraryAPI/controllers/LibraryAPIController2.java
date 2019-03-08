package edu.eci.arsw.LibraryAPI.controllers;

import edu.eci.arsw.LibraryAPI.model.Book;
import edu.eci.arsw.LibraryAPI.model.OneMinuteThread;
import edu.eci.arsw.LibraryAPI.services.LibraryServices;

import java.util.Timer;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/libraries")
@Service
public class LibraryAPIController2 {

    @Autowired
    LibraryServices ls;

    @GetMapping()
    public ResponseEntity<?> getAllLibraries() {
        try {
            return new ResponseEntity<>(ls.getAllLibraries(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se pudo realizar la consulta", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<?> getLibraryBooksById(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(ls.getLibraryBooksById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/email/{email}")
    public ResponseEntity<?> postFunctionInACinema(@PathVariable("id") long id,@PathVariable("email") String email, @RequestBody Book book){
        try {
        	OneMinuteThread hilo = new OneMinuteThread(email, book, ls, id);
        	hilo.start();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
       

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibrary(@PathVariable("id") long id) {
        try {
        	
            ls.deleteLibrary(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
