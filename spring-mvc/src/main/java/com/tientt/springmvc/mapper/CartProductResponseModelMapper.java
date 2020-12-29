package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.ResponseModelGenericMapper;
import com.tientt.springmvc.dto.ProductDTO;
import com.tientt.springmvc.responsemodel.CartProductResponseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartProductResponseModelMapper
    extends ResponseModelGenericMapper<ProductDTO, CartProductResponseModel> {
}
