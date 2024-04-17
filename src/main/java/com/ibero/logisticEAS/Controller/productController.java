package com.ibero.logisticEAS.Controller;

import com.ibero.logisticEAS.Model.Category;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("product") 
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class productController {
	
	private productService productServ;
	
	@PostMapping("/save_product")
	public ResponseEntity<Object> save_product(@RequestBody objProduct objeto){
		int idUser = objeto.idUser; 
		List<Product> product = objeto.product;
		          
		productServ.create_product(idUser, product);
		return ResponseEntity.ok().body("producto creado exitosamente");
	}
        
        @GetMapping("/readById")
        public Product getALLByID(@RequestParam long idproducts){
            return productServ.ReadProductById(idproducts);
        }
        
        @GetMapping("/readExist")
        public Boolean getProductExist(@RequestParam  long idProduct){
            return productServ.ReadProductExist(idProduct);
        }

}

class objProduct{
	public int idUser;
	public List<Product> product;
}
