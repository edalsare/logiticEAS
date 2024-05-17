/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibero.logisticEAS.Repository;

import com.ibero.logisticEAS.Model.Amount_in;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface amountInRepository extends JpaRepository<Amount_in, Integer>{
    List<Amount_in> findByBill_Idbill(int bill);
}
