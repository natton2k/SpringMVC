package com.tientt.springmvc.service;

import com.tientt.springmvc.dto.ProductDTO;
import com.tientt.springmvc.entity.Product;
import com.tientt.springmvc.mapper.ProductDTOMapper;
import com.tientt.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductDTOMapper productDTOMapper;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductDTOMapper(ProductDTOMapper productDTOMapper) {
        this.productDTOMapper = productDTOMapper;
    }

    public List<ProductDTO> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = productDTOMapper.toDTO(productList);
        return productDTOList;
    }
}
