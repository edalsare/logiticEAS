package com.ibero.logisticEAS.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Amount;
import com.ibero.logisticEAS.Model.Category;
import com.ibero.logisticEAS.Model.Locations;
import com.ibero.logisticEAS.Service.amountService;
import com.ibero.logisticEAS.Service.categoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class locationService {
	
	private locationRepository locationRepo;
	private categoryService categoryServ;
	
	public void create_location(int idCategory, int rack, int level, int position) {
		
		Category category = categoryServ.readByIdCategory(idCategory);
		
		List<String> racks = locationRepo.findDistinctRack();
		List<String> aisles = locationRepo.findDistinctAisle();
		int nrack, naisle;
		int aux = 0;
		
		if(racks.isEmpty()) {
			nrack = 0;
			naisle = 1;
		}else {
			nrack = racks.size();
			naisle = aisles.size()+1;			
			int ban = nrack%2;
			
			if(ban!=0) {
				nrack = nrack +1;
				for(int l=1; l<=level; l++) {
					for(int p=1; p<=position; p++) {
						for(int pl=1; pl<=2; pl++) {
							Locations locations = new Locations("A"+aisles.size(), "R"+nrack, "L"+l,"PL"+pl, "P"+p, false,category);
							locationRepo.save(locations);
							
						}
					}
				}
				rack = rack -1;		
				System.out.println(rack);				
			}//Fin if
		}//Fin else
					
			for(int r=1; r<=rack; r++) {
				if(aux == 2) {
					naisle = naisle +1;
					aux = 0;
				}
				aux = aux + 1;
				nrack = nrack + 1;
				for(int l=1; l<=level; l++) {
					for(int p=1; p<=position; p++) {
						for(int pl=1; pl<=2; pl++) {
							Locations locations = new Locations("A"+naisle, "R"+nrack, "L"+l,"PL"+pl, "P"+p, false,category);
							locationRepo.save(locations);
							
						}
					}
				}
			}		
	}//Fin metodo 

}
