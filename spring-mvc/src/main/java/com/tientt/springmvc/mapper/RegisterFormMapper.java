package com.tientt.springmvc.mapper;

import com.tientt.springmvc.common.mapper.ResponseModelGenericMapper;
import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.form.RegisterForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterFormMapper extends ResponseModelGenericMapper<RegistrationDTO, RegisterForm> {
}
