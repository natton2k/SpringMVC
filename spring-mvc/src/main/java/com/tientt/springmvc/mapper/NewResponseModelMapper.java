package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.ResponseModelGenericMapper;
import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.responsemodel.NewRegistrationResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface NewResponseModelMapper
        extends ResponseModelGenericMapper<RegistrationDTO, NewRegistrationResponseModel> {
    @Mappings(value = {
            @Mapping(source = "admin", target = "role")
    })
    NewRegistrationResponseModel toResponseModel(RegistrationDTO dto);
}
