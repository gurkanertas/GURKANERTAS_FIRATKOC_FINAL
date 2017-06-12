package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    public ProductService() {

        products.add(new Product(1, "nike air", 200));
        products.add(new Product(2, "addidas", 300));
    }

    public void add(String name, Integer quantity){
        //TODO
        products.add(new Product(3,name,quantity));
    }

    public void delete(Integer id) {
        //TODO
        for (Product product:products){
            if (product.getId() == id){
                products.remove(product);
            }
        }
    }

    public void update(Integer id, String name, Integer price){
        //TODO
        Product product=null;
        for(Product p:products){
            if (p.getId() == id){
                product = p;
            }
        }
        product.name = name;
        product.price = price;
    }

    public List<Product> list(){
        return products;
    }

    public Product findBy(int productId) {
        //TODO
        Product product=null;
        for (Product p:products){
            if(p.getId() == productId){
                product = p;
            }
        }
        return product;
    }
}
