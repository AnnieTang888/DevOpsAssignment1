package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.domain.User;
import com.synergisticit.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired UserService userService;
	
	//http://localhost:8080/saveUser?id=1&name=Annie01&pwd=123&email=annie@gmail.com
	@GetMapping(value="saveUser")
	public ResponseEntity<User> saveUserNo1(@RequestParam Long id, @RequestParam String name,@RequestParam String pwd, @RequestParam String email){
		System.out.println("saveuser01");
		User user = new User(id,name,pwd,email);
		System.out.println("user");
	    User retrievedUser = userService.save(user);
		return new ResponseEntity<User>(retrievedUser, HttpStatus.CREATED);
	}
	
	//http://localhost:8080/user/saveUser?id=5&name=Annie05&pwd=123&email=annie@gmail.com
	@PostMapping(value="saveUser")
	public ResponseEntity<User> saveUserNo2(@RequestParam Long id, @RequestParam String name,@RequestParam String pwd, @RequestParam String email){
		System.out.println("saveuser02");
		User user = new User(id,name,pwd,email);
		System.out.println("user");
	    User retrievedUser = userService.save(user);
		return new ResponseEntity<User>(retrievedUser, HttpStatus.CREATED);
	}
	//Create a new user
	//http://localhost:8080/user/save
	@PostMapping(value="save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		System.out.println("saveuser03");
		User retrievedUser = userService.save(user);
		return new ResponseEntity<User>(retrievedUser, HttpStatus.CREATED);
	}
	
	//Retrieve a single User by ID
	//http://localhost:8080/user/find?userId=1
	@GetMapping(value = "find")
    public ResponseEntity<?> findUserById(@RequestParam Long userId){
		User foundUser = userService.findById(userId);
    	if( foundUser != null) {
    		return new ResponseEntity<User>(foundUser,HttpStatus.FOUND);
    	}else {
    		return new ResponseEntity<String>("No User with id"+userId+".", HttpStatus.FOUND);
    	}
    }
	
	//update user
	@PutMapping(value="update")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		     User retrievedUser = userService.findById(user.getUserId());
		     HttpHeaders headers = new HttpHeaders();
		     if(retrievedUser != null) {
		    	 User updatedUser = userService.save(user);
		    	 headers.add("UPDATED - ", String.valueOf(user.getUserId()));
		    	 return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		     }else {
		    	 headers.add("NOT FOUND - ",String.valueOf(user.getUserId()));
		    	 return new ResponseEntity<String>("No user with id"+user.getUserId(), HttpStatus.BAD_REQUEST);
		     }
	};
	
	//delete user by ID
	@DeleteMapping()
	public ResponseEntity<String> deleteUserById(@RequestParam Long userId){
		System.out.println("deleteUserById(" +userId +")");
		userService.deleteById(userId);
		return new ResponseEntity<String>(HttpStatus.GONE);
	}
	
}


