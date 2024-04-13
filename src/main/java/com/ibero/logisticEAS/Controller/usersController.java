package com.ibero.logisticEAS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Service.userService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class usersController {
	
	private userService userServ;
	
	@GetMapping("/names{name}")
	public Users readUserByName(String name) {
		Users users = userServ.ReadUserByName(name); 
		return users;
	}

}
