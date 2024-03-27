package com.ibero.logisticEAS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Locations;


@Repository
public interface locationRepository extends JpaRepository<Locations, Integer>{
	
	@Query("SELECT DISTINCT l.rack FROM Locations l")
    List<String> findDistinctRack();
	
	@Query("SELECT DISTINCT l.aisle FROM Locations l")
	List<String> findDistinctAisle();

}
