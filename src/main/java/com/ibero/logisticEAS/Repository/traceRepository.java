package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Trace;

@Repository
public interface traceRepository extends JpaRepository<Trace, Integer>{

}
