//completed---fully same
package com.stackroute.myfavouriteservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String username;
	
	
	private List<Book> BookList;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<Book> getBookList() {
		return BookList;
	}


	public void setBookList(List<Book> bookList) {
		BookList = bookList;
	}


	public User(String username, List<Book> bookList) {
		super();
		this.username = username;
		BookList = bookList;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
