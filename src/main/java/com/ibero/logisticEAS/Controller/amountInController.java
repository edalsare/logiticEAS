package com.ibero.logisticEAS.Controller;

import com.ibero.logisticEAS.Model.Amount_in;
import com.ibero.logisticEAS.Service.amountInService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("AmountIn")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(
        @Autowired))
public class amountInController {
    
    private amountInService amountInserv;
    
    @GetMapping("/readByNumbill")
    public List<Amount_in> readByNumbill(@RequestParam int bill){
        return this.amountInserv.readByNumbill(bill);
    }
}
