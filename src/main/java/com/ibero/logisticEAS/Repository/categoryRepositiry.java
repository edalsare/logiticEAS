package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface categoryRepositiry extends JpaRepository<Category, Integer>{
    //@Query("SELECT ca FROM Category ca WHERE ca.namecat = ?1")
    Category findByNamecatAndSubnamecat(String names, String algo);
    
    @Query("SELECT DISTINCT ca.namecat FROM Category ca")
    List<String> findDistinctNamecat();
    
    List<Category> findByNamecat(String namecat); 

}
