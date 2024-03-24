package com.ibero.logisticEAS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Pier;
import com.ibero.logisticEAS.Repository.pierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class pierService {
	
	pierRepository pierRepo;
	
	public Pier create_pier(Pier pier) {
		return pierRepo.save(pier);
	}

}
