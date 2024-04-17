package com.ibero.logisticEAS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.logisticEAS.Model.Category;
import com.ibero.logisticEAS.Model.Product;
import com.ibero.logisticEAS.Model.Users;
import com.ibero.logisticEAS.Repository.productRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(
        @Autowired))
public class productService {

    private productRepository productRepo;
    private userService userServ;
    private categoryService catServ;

    public void create_product(int idUser, List<Product> products) {

        Users users = userServ.ReadUserById(idUser);

        for (Product product : products) {
            Category categorys = catServ.readByNameAndSub(product.getCategory().getNamecat(),
                    product.getCategory().getSubnamecat());
            Product prod = product;
            prod.setUserp(users);
            prod.setCategory(categorys);
            productRepo.save(prod);
        }

    }

    public Product ReadProductById(long idproduct) {
        return productRepo.findById(idproduct).get();
    }
    
    public Boolean ReadProductExist(long idProduct){
        return productRepo.existsById(idProduct);
    }

}
