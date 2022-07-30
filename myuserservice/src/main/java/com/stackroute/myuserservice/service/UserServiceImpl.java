//completed---fully same
package com.stackroute.myuserservice.service;

import java.util.Optional;

import com.stackroute.myuserservice.exception.PasswordMisMatchException;
import com.stackroute.myuserservice.exception.SameUsernameExistsException;
import com.stackroute.myuserservice.exception.UserAlreadyExistsException;
import com.stackroute.myuserservice.exception.UserNotFoundException;
import com.stackroute.myuserservice.model.ChangePassword;
//import com.stackroute.myuserservice.model.LogUser;
import com.stackroute.myuserservice.model.User;
import com.stackroute.myuserservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public User updateDetails(User user, String username) throws SameUsernameExistsException {
        Optional<User> user1 = userRepository.findByUsername(username);
        Optional<User> user3 = userRepository.findByUsername(user.getUsername());
        if(user3.isEmpty())
        {
        User user2 = user1.get();
        user2.setEmail(user.getEmail());
        user2.setUsername(user.getUsername());
        return userRepository.save(user2);
        }
        throw new SameUsernameExistsException();
    }
	@Override
    public User updatePassword(ChangePassword changepassword, String username) throws PasswordMisMatchException {
        Optional<User> user1 = userRepository.findByUsername(username);
        User user2 = user1.get(); 
        //Optional<User> user3 = userRepository.findByUsername();
        if(user2.getPassword().equals(changepassword.getOldpassword()))
        {
        	user2.setPassword(changepassword.getNewpassword());
        return userRepository.save(user2);
        }
        throw new PasswordMisMatchException();
    }
	
	@Override
	public User registerUser(User user) throws UserAlreadyExistsException{
		// TODO Auto-generated method stub

		Optional<User> userexisting = userRepository.findByUsername(user.getUsername());

		if (!userexisting.isEmpty()) {
			throw new UserAlreadyExistsException();
		}

		return userRepository.save(user);
	}
	
	
	@Override
	public User validateUser(String userName, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameAndPassword(userName, password);

		if (user == null) {
			throw new UserNotFoundException();
		}

		return user;
	}
}
