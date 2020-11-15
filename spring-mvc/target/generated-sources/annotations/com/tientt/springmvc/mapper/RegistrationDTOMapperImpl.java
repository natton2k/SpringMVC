package com.tientt.springmvc.mapper;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.entity.Registration;
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
public class RegistrationDTOMapperImpl implements RegistrationDTOMapper {

    @Override
    public RegistrationDTO toDTO(Registration entity) {
        if ( entity == null ) {
            return null;
        }

        RegistrationDTO registrationDTO = new RegistrationDTO();

        registrationDTO.setUsername( entity.getUsername() );
        registrationDTO.setPassword( entity.getPassword() );
        registrationDTO.setLastname( entity.getLastname() );
        registrationDTO.setAdmin( entity.isAdmin() );

        return registrationDTO;
    }

    @Override
    public Registration toEntity(RegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Registration registration = new Registration();

        registration.setUsername( dto.getUsername() );
        registration.setPassword( dto.getPassword() );
        registration.setLastname( dto.getLastname() );
        registration.setAdmin( dto.isAdmin() );

        return registration;
    }

    @Override
    public List<RegistrationDTO> toDTO(List<Registration> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RegistrationDTO> list = new ArrayList<RegistrationDTO>( entities.size() );
        for ( Registration registration : entities ) {
            list.add( toDTO( registration ) );
        }

        return list;
    }

    @Override
    public List<Registration> toEntity(List<RegistrationDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Registration> list = new ArrayList<Registration>( dtos.size() );
        for ( RegistrationDTO registrationDTO : dtos ) {
            list.add( toEntity( registrationDTO ) );
        }

        return list;
    }
}
