package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class BasketServiceTest {

    BasketService basketService = new BasketService();
    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO
        basketService.createBasket();
    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO
        basketService.addProduct(new Product(10,"a",2),1);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(2));
    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO
        basketService.addProduct(new Product(10,"a",2),2);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(4));
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO
        basketService.addProduct(new Product(10,"a",2),1);
        basketService.addProduct(new Product(10,"b",3),1);

        assertThat(basketService.getBasketPrice(), Matchers.equalTo(5));
    }
    Product product = new Product(10,"a",2);

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO
        //sepetten urunu sildi mi
        basketService.addProduct(product,1);
        basketService.addProduct(new Product(10,"b",3),1);

        basketService.removeProduct(product);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(3));


    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO
        basketService.addProduct(product,1);
        basketService.incrementQuantity(product,5);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(12));

    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO
        basketService.addProduct(product,3);
        basketService.decrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(2));
    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO
        basketService.addProduct(product,3);
        basketService.decrementQuantity(product,3);
        System.out.println((basketService.getBasketPrice()));
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(0));
    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(0));

    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali
        basketService.addProduct(product,3);//price 2
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(6));

    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali
        basketService.addProduct(product,3);//price 2
        basketService.addProduct(product,2);//price 2
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(10));
    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali
        basketService.addProduct(product,3);//price 2
        basketService.incrementQuantity(product,5);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(16));

    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali
        basketService.addProduct(product,3);//price 2
        basketService.decrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(2));
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali
        basketService.addProduct(product,3);//price 2
        basketService.addProduct(new Product(10,"b",3),1);

        basketService.incrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(13));
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali
        basketService.addProduct(product,3);//price 2
        basketService.addProduct(new Product(10,"b",3),1);

        basketService.decrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(), Matchers.equalTo(5 ));
    }


}