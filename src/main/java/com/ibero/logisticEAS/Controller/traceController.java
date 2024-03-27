package com.ibero.logisticEAS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Packages;
import com.ibero.logisticEAS.Model.Proportion;
import com.ibero.logisticEAS.Model.Trace;
import com.ibero.logisticEAS.Service.traceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("trace")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class traceController {
	
	private traceService traceServ;
	
	@PostMapping("create_trece")
	public ResponseEntity<Object> create_trace(@RequestBody objTrace objeto){
		
		traceServ.create_trace(objeto.idProduct, objeto.trace, objeto.packages, objeto.proportion);
		return ResponseEntity.ok().body("Huella creada correctamente");
		
	}

}

class objTrace{
	public int idProduct;
	public Trace trace;
	public Packages packages;
	public Proportion proportion;
}
