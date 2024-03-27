package com.audax.AudaxTimeSheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.audax.AudaxTimeSheet.entities.User;

@Repository
public interface LoginRepo extends JpaRepository<User, Long> {
//	@Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = ?1")
//	boolean existsByUsername(String user_login_id);

//	@Query("SELECT u.password FROM User u WHERE u.username = ?1")
//	String findPasswordByUsername(String user_login_id);
//	
//	// Custom query to find the user_type by username
//    @Query("SELECT u.userType FROM User u WHERE u.username = ?1")
//    String findUserTypeByUsername(String user_login_id);
}
