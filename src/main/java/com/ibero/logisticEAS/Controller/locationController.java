package com.ibero.logisticEAS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Service.locationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("location")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class locationController {
	
	private locationService locationServ;
	
	@PostMapping("/create_location")
	public ResponseEntity<Object> create_location(@RequestBody objLocation objeto){
		
		locationServ.create_location(objeto.idCategory, objeto.rack, objeto.level, objeto.position);
		return ResponseEntity.ok().body("ubicaion creda correctamente");
		
	}

}

class objLocation{
	public int idCategory;
	public int rack;
	public int level;
	public int position;
	
}
