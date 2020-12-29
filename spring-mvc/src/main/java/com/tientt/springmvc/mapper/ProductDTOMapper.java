package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.DTOGenericMapper;
import com.tientt.springmvc.dto.ProductDTO;
import com.tientt.springmvc.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper extends DTOGenericMapper<Product, ProductDTO> {
}
