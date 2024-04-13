package com.ibero.logisticEAS.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Category;
import com.ibero.logisticEAS.Service.categoryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class categoryController {
	
	private categoryService catServ;
	
	@PostMapping("/save_category")
	public ResponseEntity<Object> save_category(@RequestBody Category category){
		catServ.create_category(category);
		return ResponseEntity.ok().body("Categorya creada correctamente");
	}
        
        @GetMapping("/readname")
	public Category readNameCategory(@RequestParam String name, @RequestParam String subname){
		return catServ.readByNameAndSub(name, subname);
		
	}

}
