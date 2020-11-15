package com.tientt.springmvc.mapper;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.responsemodel.RegistrationResponseModel;
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
public class RegistrationResponseModelMapperImpl implements RegistrationResponseModelMapper {

    @Override
    public RegistrationResponseModel toResponseModel(RegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RegistrationResponseModel registrationResponseModel = new RegistrationResponseModel();

        registrationResponseModel.setUsername( dto.getUsername() );
        registrationResponseModel.setPassword( dto.getPassword() );
        registrationResponseModel.setLastname( dto.getLastname() );
        registrationResponseModel.setAdmin( dto.isAdmin() );

        return registrationResponseModel;
    }

    @Override
    public RegistrationDTO toDTO(RegistrationResponseModel responseModel) {
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
    public List<RegistrationResponseModel> toResponseModel(List<RegistrationDTO> responseModel) {
        if ( responseModel == null ) {
            return null;
        }

        List<RegistrationResponseModel> list = new ArrayList<RegistrationResponseModel>( responseModel.size() );
        for ( RegistrationDTO registrationDTO : responseModel ) {
            list.add( toResponseModel( registrationDTO ) );
        }

        return list;
    }

    @Override
    public List<RegistrationDTO> toDTO(List<RegistrationResponseModel> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<RegistrationDTO> list = new ArrayList<RegistrationDTO>( dtos.size() );
        for ( RegistrationResponseModel registrationResponseModel : dtos ) {
            list.add( toDTO( registrationResponseModel ) );
        }

        return list;
    }
}
