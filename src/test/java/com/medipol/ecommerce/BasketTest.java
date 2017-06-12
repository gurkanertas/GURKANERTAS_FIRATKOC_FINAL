package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasketTest {

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(1, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.getItems().get(0).getProduct().equals(product));

    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {

      //TODO
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(2, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.getItems().get(0).price().equals(400));

    }

    @Test
    public void shouldAddTwoDifferentProduct() throws Exception {
      //TODO

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);
        final Product product2 = new Product(2, "nike air2", 300);

        basket.addItem(new BasketItem(2, product));
        basket.addItem(new BasketItem(2, product2));

        assertTrue(basket.getItems().size() == 2);
        assertTrue(basket.getItems().get(1).getProduct().equals(product2));
    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductOneQuantity() throws Exception {

        //TODO
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(1, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.calculateBasketPrice().equals(200));
    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductTwoQuantity() throws Exception {

        //TODO
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(2, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.calculateBasketPrice().equals(400));
    }

    @Test
    public void shouldCalculateBasketPriceWithMultipleProduct() throws Exception {
        //TODO
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);
        final Product product2 = new Product(2, "nike air2", 300);

        basket.addItem(new BasketItem(1, product));
        basket.addItem(new BasketItem(1, product2));

        assertTrue(basket.getItems().size() == 2);
        assertTrue(basket.calculateBasketPrice().equals( 500));
    }

    @Test
    public void shouldUpdateBasketItemQuantity() throws Exception {
        //TODO
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(1, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.calculateBasketPrice().equals( 200));
        basket.getItems().get(0).quantity = 2;
        assertTrue(basket.calculateBasketPrice().equals( 400));
    }

}