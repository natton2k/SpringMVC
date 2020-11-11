package com.tientt.springmvc.service;

import com.tientt.springmvc.entity.Registration;
import com.tientt.springmvc.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration checkLogin(String username, String password){
        long count = registrationRepository.countByUsernameAndPassword(username, password);
        if (count != 0){
            Registration result = registrationRepository.findByUsername(username);
            return result;
        }
        return null;
    }
}
