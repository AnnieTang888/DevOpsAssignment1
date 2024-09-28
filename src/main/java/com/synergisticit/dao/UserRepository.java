package com.synergisticit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{

	//User updateUser(User user);

}
