package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private Basket basket = new Basket();

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO productName, quantity
        for (BasketItem basketItem:basket.getItems()){
            System.out.println(basketItem.getProduct().getName() + basketItem.getQuantity());
        }
    }

    public void addProduct(Product product, Integer quantity){
        //TODO
            basket.addItem(new BasketItem(quantity,product));
    }


    public void removeProduct(Product product){
        //TODO
        //sepetten ilgili ürünü silmeli
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                basket.getItems().remove(basketItem);
                break;
            }
        }
    }

    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                basketItem.quantity+=quantity;
                break;
            }
        }
    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                if (basketItem.quantity-quantity <= 0){
                    basket.getItems().remove(basketItem);
                    break;
                }else
                {
                    basketItem.quantity-=quantity;
                    break;
                }

            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice() {
        //TODO  sepet tutarini donmeli

        int price = 0;
        for (BasketItem basketItem:basket.getItems()){
            price+=basketItem.price();
        }
        return price;
    }

}
