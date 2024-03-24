package com.ibero.logisticEAS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibero.logisticEAS.Model.Category;

@Repository
public interface categoryRepositiry extends JpaRepository<Category, Integer>{

}
