package com.synergisticit.service;

import java.util.Optional;

import com.synergisticit.domain.User;

public interface UserService {
	User save(User user);
	User findById(Long userId);
	User updateUser(User user);
	void deleteById(Long userId);

}
