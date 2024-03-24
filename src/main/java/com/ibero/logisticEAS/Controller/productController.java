package com.ibero.logisticEAS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Service.productService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("product") 
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class productController {
	
	private productService productServ;
	
	@PostMapping("/save_product")
	public ResponseEntity<Object> save_product(@RequestBody objProduct objeto){
		int idUser = objeto.idUser;
		int idCategory = objeto.idCategory;
		List<Product> product = objeto.product;
		
		productServ.create_product(idUser, idCategory, product);
		return ResponseEntity.ok().body("producto creado exitosamente");
	}

}

class objProduct{
	public int idUser;
	public int idCategory;
	public List<Product> product;
}
