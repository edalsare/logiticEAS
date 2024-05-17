package com.ibero.logisticEAS.Service;

import com.ibero.logisticEAS.Model.Amount_in;
import com.ibero.logisticEAS.Repository.amountInRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(
        @Autowired))
public class amountInService {
    private amountInRepository amountInRepo;
    
    public List<Amount_in> readByNumbill(int bill){
        return this.amountInRepo.findByBill_Idbill(bill);
    }
}
