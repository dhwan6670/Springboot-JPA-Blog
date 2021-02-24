package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

//DAO - Data Access Object
//자동으로 bean등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	//SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}	
	// JPA Naming 전략
	// SELECT * FROM user WHEREuser name = ? AND password = ?; <-를 나타냄  
//	User findByUsernameAndPassword(String username, String password); //전통 로그인
	
//	@Query(value = "SELECT * FROM user WHEREuser name = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String password); //쿼리 로그인

