package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.DTOGenericMapper;
import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.entity.Registration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationDTOMapper extends DTOGenericMapper<Registration, RegistrationDTO> {
}
