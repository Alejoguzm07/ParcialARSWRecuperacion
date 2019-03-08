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
			.domain("sandboxa0eb7d3e45004fbe90ced64efd57a7f7.mailgun.org").apiKey("0aae764cbf6d69016752eb8e493315a7-acb0b40c-a31f77f6")
			.from("test@mail.com", "postmaster@sandboxa0eb7d3e45004fbe90ced64efd57a7f7.mailgun.org");
			 Mail.using(configuration).to(userName).subject("Registro exitoso").text("Se ha registrado el libro"+book.getNombre()).build().send()
			.responseMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
