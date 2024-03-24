package com.ibero.logisticEAS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Pier;
import com.ibero.logisticEAS.Service.pierService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("pier")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class pierController {
	
	private pierService pierServ;
	
	@PostMapping("/save_pier")
	public ResponseEntity<Object> save_pier(@RequestBody Pier pier){
		pierServ.create_pier(pier);
		return ResponseEntity.ok().body("Muelle ingresado correctamente");
	}

}
