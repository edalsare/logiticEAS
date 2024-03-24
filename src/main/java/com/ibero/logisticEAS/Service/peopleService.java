package com.ibero.logisticEAS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.People;
import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Repository.peopleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class peopleService {
	
	peopleRepository peopleRepo;
	
	public People create_people(People people, Users users){
		
		people.setUsers(users);
		users.setPeople(people);
		return peopleRepo.save(people);
		
	}

}
 