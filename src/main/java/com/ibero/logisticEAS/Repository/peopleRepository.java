package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.People;

@Repository
public interface peopleRepository extends JpaRepository<People, Integer>{

}
