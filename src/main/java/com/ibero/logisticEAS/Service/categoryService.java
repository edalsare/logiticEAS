package com.ibero.logisticEAS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Category;
import com.ibero.logisticEAS.Repository.categoryRepositiry;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class categoryService {
	
	private categoryRepositiry cateRepo;
	
	public Category create_category(Category category) {
		return cateRepo.save(category);
	}
	
	public Category readByIdCategory(int id_category) {
		return cateRepo.findById(id_category).get();
	}
        
        public Category readByNameAndSub(String name, String Subname) {
		return cateRepo.findByNamecatAndSubnamecat(name, Subname);
	}

}
