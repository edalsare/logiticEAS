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
import com.ibero.logisticEAS.Service.billService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("bill")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class billController {
	
	private billService billserv;
	
	@PostMapping("/create_bill")
	public ResponseEntity<Object> create_bill(@RequestBody objBill objeto){
		int idUser = objeto.idUser;
		List<Long>idProduct= objeto.idProduct;
		Bill bill = objeto.bill;
		List<Amount_in> amountIn = objeto.amountIn;
		billserv.createBill(idProduct, idUser, bill, amountIn);
		return ResponseEntity.ok().body("Factura ingresada correctamente");
		
		
	}

}

class objBill{
	public int idUser;
	public List<Long>idProduct;
	public Bill bill;
	public List<Amount_in> amountIn;
}
