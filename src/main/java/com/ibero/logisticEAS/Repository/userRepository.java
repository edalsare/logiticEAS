package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Users;

@Repository
public interface userRepository extends JpaRepository<Users, Integer>{
	
	Users findByNameuser( String names);

}
