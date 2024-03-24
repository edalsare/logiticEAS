package com.ibero.logisticEAS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Category;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Repository.productRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class productService {
	
	private productRepository productRepo;
	private userService userServ;
	private categoryService catServ;
	
	public void create_product(int idUser, int idCategory, List<Product> products) {
		
		Users users = userServ.ReadUserById(idUser);
		Category category = catServ.readByIdCategory(idCategory);
		
		for(Product product: products) {
			Product prod = product;
			prod.setUserp(users);
			prod.setCategory(category);
			productRepo.save(prod);
		}		
		
	}

}
