package com.ibero.logisticEAS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Amount_in;
import com.ibero.logisticEAS.Model.Bill;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Service.billService;
import com.ibero.logisticEAS.Model.Users;
import java.util.ArrayList;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("bill")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class billController {
	
	private billService billserv;
	 
	@PostMapping("/create_bill")
	public ResponseEntity<Object> create_bill(@RequestBody objBill objeto){
            
		Users users = objeto.users;
		//List<Long>idProduct= objeto.idProduct;
		Bill bill = objeto.bill;
                //Bill bill = objeto.products;
		//List<Amount_in> amountIn = objeto.amountIn;
		billserv.createBill(objeto.products, users, bill);
		return ResponseEntity.ok().body("Factura ingresada correctamente");
		
		
	}

}

class objBill{
	public Users users;
	//public List<Long>idProduct;
	public Bill bill;
	//public List<Amount_in> amountIn;
        public List<Object[]> products = new ArrayList<>();
}
