package edu.eci.arsw.LibraryAPI.model;

import edu.eci.arsw.LibraryAPI.services.LibraryServices;



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
		Configuration configuration = new Configuration()
			    .domain("somedomain.com")
			    .apiKey("key-xxxxxxxxxxxxxxxxxxxxxxxxx")
			    .from("Test account", "postmaster@somedomain.com");
	}
	public void run() {
		try {
			this.sleep(60000);
			System.err.println(userName);
			System.err.println(id);
			ls.addBooksByLibraryID(id, book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
