package com.ibero.logisticEAS.Service;

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
	
	public Bill createBill(List<Integer> idProduct, int idUser, Bill bill, List<Amount_in> amountIn) {
		
		List<Product> products = new ArrayList<>();
		List<Amount_in> amounts = new ArrayList<>();
		Users users = userServ.ReadUserById(idUser);
		LocalDate dat = LocalDate.now();
		
		
		for(int i=0; i<idProduct.size(); i++) {
			Product pro = prodServ.ReadProductById(idProduct.get(i));
			Amount_in amount = amountIn.get(i);
			amount.setProduct2(pro);
			amount.setBill(bill);
			amounts.add(amount);
			products.add(pro);
		}
		
		bill.setAmount_in(amounts);
		bill.setProduct(products);
		bill.setUsers(users);
		bill.setDate_bill(dat);
		
		return billRepo.save(bill);
		
	}

}
