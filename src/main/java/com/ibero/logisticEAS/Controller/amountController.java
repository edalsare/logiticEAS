package com.ibero.logisticEAS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Amount;
import com.ibero.logisticEAS.Service.amountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("amount")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class amountController {
	
	private amountService amountServ;
	
	@PostMapping("/create_amount")
	public ResponseEntity<Object> create_amount(@RequestBody objAmount objeto){
		amountServ.create_bill(objeto.idProduct, objeto.idPier, objeto.amounts);
		return ResponseEntity.ok().body("Cantidades ingresadas correctamente");
		
	}

}

class objAmount{
	public List<Integer> idProduct;
	public int idPier;
	public List<Amount> amounts; 
	
}
