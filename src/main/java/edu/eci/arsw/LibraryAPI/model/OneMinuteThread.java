package edu.eci.arsw.LibraryAPI.model;

import edu.eci.arsw.LibraryAPI.services.LibraryServices;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;



public class OneMinuteThread extends Thread{
	
	String userName;
	Book book;
	LibraryServices ls;
	long id;
	
	public OneMinuteThread(String email, Book book, LibraryServices ls, long id) {
		this.userName = email;
		this.book = book;
		this.ls = ls;
		this.id = id;
	}
	public void run() {
		try {
			this.sleep(60000);
			ls.addBooksByLibraryID(id, book);
			Configuration configuration = new Configuration()
			.domain("").apiKey("")
			.from("test@mail.com", "");
			 Mail.using(configuration).to(userName).subject("Registro exitoso").text("Se ha registrado el libro"+book.getNombre()).build().send()
			.responseMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
