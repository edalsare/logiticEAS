package com.ibero.logisticEAS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Packages;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Model.Proportion;
import com.ibero.logisticEAS.Model.Trace;
import com.ibero.logisticEAS.Repository.traceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class traceService {
	
	private productService productServ;
	private traceRepository traceRepo;
	
	public Trace create_trace(int idProduct, Trace trace, Packages packages, Proportion proportion) {
		Product product = productServ.ReadProductById(idProduct);
		
		trace.setProductt(product);
		packages.setTrace(trace);
		packages.setProportion(proportion);
		proportion.setPackages(packages);
		trace.setPackages(packages);
		
		return traceRepo.save(trace);
		
	}

}
