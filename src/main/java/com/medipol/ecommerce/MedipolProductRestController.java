package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("MedipolProductRestController")//TODO
@RestController
public class MedipolProductRestController {
    @Autowired
    private BasketService basketService;
    @Autowired private ProductService productService;


    @RequestMapping(path = "/add")
    public Product add(@RequestParam int productId,@RequestParam String name, @RequestParam int price,int quantity) {

        Product product = new Product(productId,name,price);
        basketService.addProduct(product, quantity);
        return  product;

    }
    @RequestMapping(path = "/delete")
    public void delete(@RequestParam int productId) {

        Product product = productService.findBy(productId);
        basketService.removeProduct(product);
        return;

    }
    @RequestMapping(path = "/update")
    public Basket update(@RequestParam int productId, @RequestParam String name) {

        return null;

    }
    @RequestMapping(path = "/list")
    public List<BasketItem> list(@RequestParam int basketId) {

        return basketService.getBasket().getItems();

    }


}
