package com.ibero.logisticEAS.Repository;

import com.ibero.logisticEAS.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Trace;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface traceRepository extends JpaRepository<Trace, Integer>{
    
    @Query("SELECT pro.idproduct, pro.nameproduct, pro.suplier " +
            "FROM Product pro " +
            "LEFT OUTER JOIN Trace tra " +
            "ON pro.idproduct = tra.productt.idproduct " +
            "WHERE tra.productt.idproduct is null")
    List<Object> findAllProductAndTrace();
 
}
