package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Bill;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface billRepository extends JpaRepository<Bill, Integer> {
    Boolean existsByNumbill(String numbill);
    
    Bill findByNumbill(String numbill);
    
    @Query("SELECT  b.numbill FROM Bill b")
    List<String> findLagency(String lagency);
    
    @Query("SELECT DISTINCT b.lagency FROM Bill b")
    List<String> findDistinctLagency();
}
