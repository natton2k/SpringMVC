package com.tientt.springmvc.mapper;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.form.RegisterForm;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-11T11:20:25+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_272 (Eclipse OpenJ9)"
)
@Component
public class RegisterFormMapperImpl implements RegisterFormMapper {

    @Override
    public RegisterForm toResponseModel(RegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RegisterForm registerForm = new RegisterForm();

        registerForm.setUsername( dto.getUsername() );
        registerForm.setPassword( dto.getPassword() );
        registerForm.setLastname( dto.getLastname() );

        return registerForm;
    }

    @Override
    public RegistrationDTO toDTO(RegisterForm responseModel) {
        if ( responseModel == null ) {
            return null;
        }

        RegistrationDTO registrationDTO = new RegistrationDTO();

        registrationDTO.setUsername( responseModel.getUsername() );
        registrationDTO.setPassword( responseModel.getPassword() );
        registrationDTO.setLastname( responseModel.getLastname() );

        return registrationDTO;
    }

    @Override
    public List<RegisterForm> toResponseModel(List<RegistrationDTO> responseModel) {
        if ( responseModel == null ) {
            return null;
        }

        List<RegisterForm> list = new ArrayList<RegisterForm>( responseModel.size() );
        for ( RegistrationDTO registrationDTO : responseModel ) {
            list.add( toResponseModel( registrationDTO ) );
        }

        return list;
    }

    @Override
    public List<RegistrationDTO> toDTO(List<RegisterForm> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<RegistrationDTO> list = new ArrayList<RegistrationDTO>( dtos.size() );
        for ( RegisterForm registerForm : dtos ) {
            list.add( toDTO( registerForm ) );
        }

        return list;
    }
}
