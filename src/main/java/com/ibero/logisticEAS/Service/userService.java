package com.ibero.logisticEAS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Repository.userRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class userService {
	
	private userRepository userRepo;
	
	public Users ReadUserById(int id_user) {
		return userRepo.findById(id_user).get();
	}
	
	public Users ReadUserByName(String name_user) {
		return userRepo.findByNameuser(name_user);
	}

}
