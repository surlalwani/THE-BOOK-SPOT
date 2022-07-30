package com.stackroute.myfavouriteservice.controller;

import java.util.List;

import com.stackroute.myfavouriteservice.exception.BookAlreadyExistsException;
import com.stackroute.myfavouriteservice.exception.BookNotFoundException;
import com.stackroute.myfavouriteservice.model.Book;
import com.stackroute.myfavouriteservice.model.User;
import com.stackroute.myfavouriteservice.service.FavouriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/favoriteservice")
public class FavoriteController {
	
	private ResponseEntity responseEntity;

	private FavouriteService favService;

	public FavoriteController() {
		super();
	}

	@Autowired
	public FavoriteController(FavouriteService favService) {
		super();
		this.favService = favService;
	}
	
	
	@PostMapping("/user/{username}/name")
	public ResponseEntity<?> addBookToFavoriteList(@RequestBody Book book,
			@PathVariable String username) throws BookAlreadyExistsException {
	
		if(username!=null) {
			try {
				User user1 = favService.saveBookToFavorite(book, username);
				if(user1.getUsername()!=null) {
					responseEntity = new ResponseEntity<User>(user1, HttpStatus.CREATED);
				}
				else {
					System.out.println("Useername not found...mayebe its null");
				}
				
			} catch (BookAlreadyExistsException e) {
				throw new BookAlreadyExistsException();
			} catch (Exception e) {
				responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return responseEntity;
			
		}
		else {
			return null;
		}

		

	}
	
	@DeleteMapping("/user/{username}/{name}")
	public ResponseEntity<?> deleteFromList(@PathVariable String name, @PathVariable String username)
			throws BookNotFoundException {

		try {
			User user1 = favService.deleteBookFromFavorite(name, username);
			responseEntity = new ResponseEntity<User>(user1, HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException();
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}
	
	@GetMapping("/user/{username}/name")
	public ResponseEntity<?> getBookList(@PathVariable String username) throws BookNotFoundException {

		try {
			List<Book> bookList = favService.getBookList(username);
			responseEntity = new ResponseEntity(bookList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}


}




