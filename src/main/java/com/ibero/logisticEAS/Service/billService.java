package com.ibero.logisticEAS.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Amount_in;
import com.ibero.logisticEAS.Model.Bill;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Repository.billRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class billService {
	
	private billRepository billRepo;
	private productService prodServ;
	private userService userServ;
	
	public Bill createBill(List<Object[]> productos, Users user, Bill bill) {
		
		List<Product> products = new ArrayList<>();
		List<Amount_in> amounts = new ArrayList<>();
		//Users users = userServ.ReadUserById(idUser);
		LocalDate dat = LocalDate.now();
		
		
		for(Object[] product: productos) {
                    
			//Product pro = prodServ.ReadProductById(idProduct.get(i));
                        ObjectMapper mapper = new ObjectMapper();
                        Product producto = new Product();
                        producto = mapper.convertValue(product[0], Product.class);
                        
			Amount_in amount = mapper.convertValue(product[1], Amount_in.class);
			amount.setProduct2(producto);
			amount.setBill(bill);
			amounts.add(amount);
			products.add(producto);
		}
		
		bill.setAmount_in(amounts);
		bill.setProduct(products);
		bill.setUsers(user);
		bill.setDatebill(dat);
		
		return billRepo.save(bill);
		
	}

}
