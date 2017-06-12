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

@RequestMapping("MedipolBasketRestController")//TODO
@RestController
public class MedipolBasketRestController {

    @Autowired private  BasketService basketService;
    @Autowired private ProductService productService;

    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    @RequestMapping(path = "/getBasketDetail")
    public Basket getBasketDetail() {

        return basketService.getBasket();

    }

    @RequestMapping(path = "/remove")
    public void remove(@RequestParam int productId) {

        BasketItem i = null;
        for(BasketItem basketItem: basketService.getBasket().getItems()){
            if (basketItem.getProduct().getId().equals(productId)){
                i= basketItem;
                break;
            }
        }
        basketService.getBasket().getItems().remove(i);

    }
    @RequestMapping(path = "/incrementQuantity")
    public void incrementQuantity(@RequestParam int productId,int quantity) {

        Product product = productService.findBy(productId);
        basketService.incrementQuantity(product,quantity);

    }
    @RequestMapping(path = "/decrementQuantity")

    public void decrementQuantity(@RequestParam int productId,int quantity) {

        Product product = productService.findBy(productId);
        basketService.decrementQuantity(product,quantity);

    }
    @RequestMapping(path = "/getBasketPrice")

    public void getBasketPrice() {

       basketService.printBasketDetail();

    }


}
