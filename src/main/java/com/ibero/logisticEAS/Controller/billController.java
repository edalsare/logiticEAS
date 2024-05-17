package com.ibero.logisticEAS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.logisticEAS.Model.Amount_in;
import com.ibero.logisticEAS.Model.Bill;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Service.billService;
import com.ibero.logisticEAS.Model.Users;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("bill")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(
        @Autowired))
public class billController {

    private billService billserv;

    @PostMapping("/create_bill")
    public ResponseEntity<Object> create_bill(@RequestBody objBill objeto) {
        Users users = objeto.users;
        Bill bill = objeto.bill;
        billserv.createBill(objeto.products, users, bill);
        return ResponseEntity.ok().body("Factura ingresada correctamente");
    }
    
    @GetMapping("/existsByNumbill")
    public Boolean existsByNumBill(@RequestParam String numbill){
        return this.billserv.existsByNumbill(numbill);
    }
    
    @GetMapping("/allBill")
    public List<Bill> readByALL(){  
        return this.billserv.readByAll();
    }
    
    @GetMapping("/agencia")
    public List<String> readDistincLagency(){
        return this.billserv.readDistincLagency();
    }
    
    @GetMapping("/readByAgency")
    public List<String> readByLagency(@RequestParam String lagency){
        return this.billserv.readLagency(lagency);
    }
    
    @GetMapping("/readByNumbill")
    public Bill readByNumbill(@RequestParam String numbill){
         return this.billserv.readByNumbill(numbill);
    }
}

class objBill {

    public Users users;
    public Bill bill;
    public List<Object[]> products = new ArrayList<>();
}
