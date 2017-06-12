package com.medipol.ecommerce.service;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class ProductServiceTest {

    ProductService productService = new ProductService();
    @Test
    public void shouldListInitialProducts() throws Exception {
        //TODO
        assertThat(new ProductService().list().size(), Matchers.equalTo(2));
    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO
        productService.add("a",1);
         assertThat(productService.list().get(2).getName(),Matchers.equalTo("a"));
    }

    @Test
    public void shouldMultipleOneProduct() throws Exception {
        //TODO
        productService.add("a",1);
        productService.add("b",1);
        assertThat(productService.list().get(3).getName(),Matchers.equalTo("b"));
    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO
        productService.delete(1);
        assertThat(productService.list().get(0).getName(),Matchers.equalTo("addidas"));
    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO
        productService.update(1,"new balnce",200);
        assertThat(productService.list().get(0).getName(),Matchers.equalTo("new balnce"));
    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO
        productService.update(1,"adidas",555);
        assertThat(productService.list().get(0).getPrice(),Matchers.equalTo(555));
    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO
        productService.update(1,"new balnce",555);
        assertThat(productService.list().get(0).getPrice(),Matchers.equalTo(555));
        assertThat(productService.list().get(0).getName(),Matchers.equalTo("new balnce"));


    }

}