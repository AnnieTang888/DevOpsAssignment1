package com.synergisticit.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.dao.UserRepository;
import com.synergisticit.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@Override
	public User updateUser(User user) {		
		return null;
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

}
