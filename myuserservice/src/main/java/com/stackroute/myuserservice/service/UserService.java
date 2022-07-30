//completed---done---fully same
package com.stackroute.myuserservice.service;

import com.stackroute.myuserservice.exception.PasswordMisMatchException;
import com.stackroute.myuserservice.exception.SameUsernameExistsException;
import com.stackroute.myuserservice.exception.UserAlreadyExistsException;
import com.stackroute.myuserservice.exception.UserNotFoundException;
import com.stackroute.myuserservice.model.ChangePassword;
//import com.stackroute.myuserservice.model.LogUser;
import com.stackroute.myuserservice.model.User;
//import com.stackroute.myuserservice.repository.UserRepository;

public interface UserService {
	
	
	public User registerUser(User user) throws UserAlreadyExistsException;
	public User validateUser(String userName, String password) throws UserNotFoundException;
	public User updateDetails(User user, String username) throws SameUsernameExistsException;
	public User updatePassword(ChangePassword changepassword,String username) throws PasswordMisMatchException;
}
