package org.conferencesproject.com.DAO;

import org.conferencesproject.com.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UserRepository extends JpaRepository<User, Long>{
	
	/* check username and
	 *  password of author 
	 *   */
	@Query("select u FROM User u where u.userFullName = :userFullName and u.password = :password") 
	User findUserByEmailAndPassword(@Param("userFullName") String username , @Param("password") String password);
	
}
