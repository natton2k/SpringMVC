package com.tientt.springmvc.controller;

import com.tientt.springmvc.dto.ProductDTO;
import com.tientt.springmvc.entity.Product;
import com.tientt.springmvc.mapper.ProductResponseModelMapper;
import com.tientt.springmvc.responsemodel.ProductResponseModel;
import com.tientt.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductRestController {
    private ProductService productService;
    private ProductResponseModelMapper productResponseModelMapper;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductResponseModelMapper(ProductResponseModelMapper productResponseModelMapper) {
        this.productResponseModelMapper = productResponseModelMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductResponseModel>> getAllProducts(){
        List<ProductDTO> productDTOList = productService.getAllProducts();
        List<ProductResponseModel> productResponseModelList =
                productResponseModelMapper.toResponseModel(productDTOList);
        return ResponseEntity.ok(productResponseModelList);
    }
}
