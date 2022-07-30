//Completed---done---fully same

package com.stackroute.myuserservice.repository;
import java.util.Optional;
//import com.stackroute.myuserservice.model.LogUser;
import com.stackroute.myuserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public Optional<User> findByUsername(String username);	
}
