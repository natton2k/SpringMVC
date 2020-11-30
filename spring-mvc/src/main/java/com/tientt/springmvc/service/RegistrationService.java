package com.tientt.springmvc.service;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.entity.Registration;
import com.tientt.springmvc.mapper.RegistrationDTOMapper;
import com.tientt.springmvc.mapper.UpdateUserModelMapper;
import com.tientt.springmvc.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private RegistrationDTOMapper registrationDTOMapper;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, RegistrationDTOMapper registrationDTOMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationDTOMapper = registrationDTOMapper;
    }

    public Registration checkLogin(String username, String password) {
        long count = registrationRepository.countByUsernameAndPassword(username, password);
        if (count != 0) {
            Registration result = registrationRepository.findByUsername(username);
            return result;
        }
        return null;
    }

    public List<RegistrationDTO> searchByLastName(String lastName) {
        List<Registration> registrationList = registrationRepository.getByLastnameContainingIgnoreCase(lastName);
        List<RegistrationDTO> registrationDTOList = registrationDTOMapper.toDTO(registrationList);
        return registrationDTOList;
    }

    public boolean update(RegistrationDTO registrationDTO) {
        Registration registration = this.registrationDTOMapper.toEntity(registrationDTO);
        if (registrationRepository.findById(registration.getUsername()).
                orElseThrow(EntityNotFoundException::new) != null) {
            registrationRepository.saveAndFlush(registration);
        }
        return true;
    }

    public boolean delete(String username) {
        int result = registrationRepository.deleteByUsername(username);
        return result == 1;
    }

    public boolean isUsernameExisted(String username) {
        Registration registration = this.registrationRepository.findByUsername(username);
        return registration != null;
    }

    public void createUser(RegistrationDTO dto){
        Registration registration = this.registrationDTOMapper.toEntity(dto);
        this.registrationRepository.saveAndFlush(registration);
    }
}
















