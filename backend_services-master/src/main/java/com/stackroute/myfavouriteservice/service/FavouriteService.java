package com.stackroute.myfavouriteservice.service;

import java.util.List;

import com.stackroute.myfavouriteservice.exception.BookAlreadyExistsException;
import com.stackroute.myfavouriteservice.exception.BookNotFoundException;
import com.stackroute.myfavouriteservice.model.Book;
import com.stackroute.myfavouriteservice.model.User;

import org.springframework.stereotype.Service;


public interface FavouriteService {
	
	public User saveBookToFavorite(Book book, String username) throws BookAlreadyExistsException;
	public User deleteBookFromFavorite(String key , String username ) throws BookNotFoundException;
	public List<Book> getBookList(String username ) throws Exception;

}
