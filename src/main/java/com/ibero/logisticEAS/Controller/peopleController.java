package com.ibero.logisticEAS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.People;
import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Service.peopleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("people")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class peopleController {
	
private peopleService peopleServ;
	
	@PostMapping("/save_people")
	public  ResponseEntity<Object> peoples(@RequestBody objPeople peoples){
		People people = peoples.people;
		Users usres = peoples.users;
		peopleServ.create_people(people, usres);
		return ResponseEntity.ok().body("usuario registrado satisfactoriamente");
		
	}

}

class objPeople{
	public People people;
	public Users users;
}
