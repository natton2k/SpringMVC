package com.tientt.springmvc.controller;

import com.tientt.springmvc.response.CommonResponse;
import com.tientt.springmvc.responsemodel.CartProductResponseModel;
import com.tientt.springmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppingCart")
public class CartRestController {
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public ResponseEntity<List<CartProductResponseModel>> getCart(){
        List<CartProductResponseModel> responseModelList =
                cartService.getProductsAsList();
        if (responseModelList == null){
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(responseModelList);
    }

    @PostMapping("/products/{productID}")
    public ResponseEntity<CommonResponse> addProductToCart(@PathVariable Integer productID){
        cartService.addProduct(productID);
        return ResponseEntity.ok(CommonResponse.build(true, "Add successfully", null));
    }

    @DeleteMapping("/products/{productID}")
    public ResponseEntity<CommonResponse> removeProductInCart(@PathVariable Integer productID){
        cartService.removeProduct(productID);
        return ResponseEntity.ok(CommonResponse.build(true, "Remove successfully", null));
    }
}
