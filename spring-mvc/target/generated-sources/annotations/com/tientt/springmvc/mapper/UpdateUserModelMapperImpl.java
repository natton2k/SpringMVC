package com.tientt.springmvc.mapper;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.request.UpdateUserRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-15T18:45:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_272 (Eclipse OpenJ9)"
)
@Component
public class UpdateUserModelMapperImpl implements UpdateUserModelMapper {

    @Override
    public UpdateUserRequest toResponseModel(RegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UpdateUserRequest updateUserRequest = new UpdateUserRequest();

        updateUserRequest.setUsername( dto.getUsername() );
        updateUserRequest.setPassword( dto.getPassword() );
        updateUserRequest.setLastname( dto.getLastname() );
        updateUserRequest.setAdmin( dto.isAdmin() );

        return updateUserRequest;
    }

    @Override
    public RegistrationDTO toDTO(UpdateUserRequest responseModel) {
        if ( responseModel == null ) {
            return null;
        }

        RegistrationDTO registrationDTO = new RegistrationDTO();

        registrationDTO.setUsername( responseModel.getUsername() );
        registrationDTO.setPassword( responseModel.getPassword() );
        registrationDTO.setLastname( responseModel.getLastname() );
        registrationDTO.setAdmin( responseModel.isAdmin() );

        return registrationDTO;
    }

    @Override
    public List<UpdateUserRequest> toResponseModel(List<RegistrationDTO> responseModel) {
        if ( responseModel == null ) {
            return null;
        }

        List<UpdateUserRequest> list = new ArrayList<UpdateUserRequest>( responseModel.size() );
        for ( RegistrationDTO registrationDTO : responseModel ) {
            list.add( toResponseModel( registrationDTO ) );
        }

        return list;
    }

    @Override
    public List<RegistrationDTO> toDTO(List<UpdateUserRequest> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<RegistrationDTO> list = new ArrayList<RegistrationDTO>( dtos.size() );
        for ( UpdateUserRequest updateUserRequest : dtos ) {
            list.add( toDTO( updateUserRequest ) );
        }

        return list;
    }
}
