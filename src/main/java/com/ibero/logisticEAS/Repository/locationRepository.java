package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Location;

@Repository
public interface locationRepository extends JpaRepository<Location, Integer>{
	
	

}
