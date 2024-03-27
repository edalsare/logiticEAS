package com.ibero.logisticEAS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Amount;
import com.ibero.logisticEAS.Model.Pier;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Repository.amountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class amountService {
	
	private amountRepository amountRepo;
	private productService prodServ;
	private pierService pierServ;
	
	public void create_bill(List<Integer>idProduct, int idPier, List<Amount> amounts) {
		
		
		Pier pier = pierServ.readPierById(idPier);
		for(int i=0; i<idProduct.size(); i++) {
			Product product = prodServ.ReadProductById(idProduct.get(i));
			Amount amount = amounts.get(i);
			amount.setPier(pier);
			amount.setProducta(product);
			amountRepo.save(amount);
		}
		
	}

}
