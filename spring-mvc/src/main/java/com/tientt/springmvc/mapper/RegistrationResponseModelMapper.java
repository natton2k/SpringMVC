package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.ResponseModelGenericMapper;
import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.responsemodel.RegistrationResponseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationResponseModelMapper extends ResponseModelGenericMapper<RegistrationDTO, RegistrationResponseModel> {
}
