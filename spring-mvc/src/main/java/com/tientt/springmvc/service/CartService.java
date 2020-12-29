package com.tientt.springmvc.service;

import com.tientt.springmvc.dto.ProductDTO;
import com.tientt.springmvc.entity.Product;
import com.tientt.springmvc.mapper.CartProductResponseModelMapper;
import com.tientt.springmvc.mapper.ProductDTOMapper;
import com.tientt.springmvc.repository.ProductRepository;
import com.tientt.springmvc.responsemodel.CartProductResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class CartService {
    private Map<ProductDTO, Integer> products;
    private ProductRepository productRepository;
    private ProductDTOMapper productDTOMapper;
    private CartProductResponseModelMapper cartProductResponseModelMapper;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductDTOMapper(ProductDTOMapper productDTOMapper) {
        this.productDTOMapper = productDTOMapper;
    }

    @Autowired
    public void setCartProductResponseModelMapper(CartProductResponseModelMapper cartProductResponseModelMapper) {
        this.cartProductResponseModelMapper = cartProductResponseModelMapper;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    public List<CartProductResponseModel> getProductsAsList(){
        if (products == null){
            return null;
        }
        List<CartProductResponseModel> responseModelList = new ArrayList<>();
        for (ProductDTO dto : products.keySet()){
            CartProductResponseModel responseModel =
                    cartProductResponseModelMapper.toResponseModel(dto);
            responseModel.setQuantity(products.get(dto));
            responseModelList.add(responseModel);
        }
        return responseModelList;
    }

    public void addProduct(ProductDTO dto){
        if (products == null){
            products = new HashMap<>();
        }
        int quantity = 1;
        if (products.containsKey(dto)){
            quantity = products.get(dto) + 1;
        }
        products.put(dto, quantity);
    }

    public void addProduct(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        ProductDTO productDTO = productDTOMapper.toDTO(product);
        this.addProduct(productDTO);
    }

    public void removeProduct(ProductDTO dto){
        if (this.products == null){
            return;
        }
        if (products.containsKey(dto)){
            products.remove(dto);
            if (products.isEmpty()){
                products = null;
            }
        }
    }

    public void removeProduct(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        ProductDTO productDTO = productDTOMapper.toDTO(product);
        this.removeProduct(productDTO);
    }
}
