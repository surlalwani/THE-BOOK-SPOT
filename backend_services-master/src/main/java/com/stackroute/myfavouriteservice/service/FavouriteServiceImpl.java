package com.stackroute.myfavouriteservice.service;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.myfavouriteservice.exception.BookAlreadyExistsException;
import com.stackroute.myfavouriteservice.exception.BookNotFoundException;
import com.stackroute.myfavouriteservice.model.Book;
import com.stackroute.myfavouriteservice.model.User;
import com.stackroute.myfavouriteservice.repository.FavouriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FavouriteServiceImpl implements FavouriteService{
	
//	@Autowired
	private FavouriteRepository favRepository;
	
	@Autowired
	public FavouriteServiceImpl(FavouriteRepository favRepository) {
		super();
		this.favRepository = favRepository;
	}

	@Override
	public User saveBookToFavorite(Book book, String username) throws BookAlreadyExistsException {
		// TODO Auto-generated method stub
		User user1 = favRepository.findByUsername(username);
		
		if (user1 == null) {
			user1 = new User(username, new ArrayList<Book>());
		}
		
		List<Book> bookList = user1.getBookList();

		if (bookList != null) {
			for (Book p : bookList) {

				if (p.getName().equals (book.getName())) {
					throw new BookAlreadyExistsException();
				}
			}

			bookList.add(book);
			
			System.out.println("Saving Data if block");
			user1.setBookList(bookList);
			favRepository.save(user1);
		}

		else {
			bookList = new ArrayList();
			bookList.add(book);

			user1.setBookList(bookList);
			favRepository.save(user1);
		}
		return user1;

	}
	
	

	@Override
	public User deleteBookFromFavorite(String name, String username) throws BookNotFoundException {
		User user1 = favRepository.findByUsername(username);
		boolean trackFound = false;
		int indexnum = 0;
		List<Book> bookList = user1.getBookList();

		if (bookList != null && bookList.size() > 0) {
			for (Book t : bookList) {
				indexnum++;
				if (t.getName().equals(name)) {
					bookList.remove(indexnum - 1);
					user1.setBookList(bookList);
					favRepository.save(user1);
					break;
				}
			}

		}

		else {
			throw new BookNotFoundException();
		}
		return user1;
	}

	@Override
	public List<Book> getBookList(String username) throws Exception {
		User user1 = favRepository.findByUsername(username);
		return user1.getBookList();
	}


}
