package com.tientt.springmvc.controller;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.mapper.RegistrationResponseModelMapper;
import com.tientt.springmvc.mapper.UpdateUserModelMapper;
import com.tientt.springmvc.request.UpdateUserRequest;
import com.tientt.springmvc.response.CommonResponse;
import com.tientt.springmvc.responsemodel.RegistrationResponseModel;
import com.tientt.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class RegistrationRestController {

    private RegistrationResponseModelMapper responseModelMapper;
    private RegistrationService registrationService;
    private UpdateUserModelMapper updateUserModelMapper;

    @Autowired
    public RegistrationRestController(RegistrationResponseModelMapper responseModelMapper,
                                      RegistrationService registrationService,
                                      UpdateUserModelMapper updateUserModelMapper) {
        this.responseModelMapper = responseModelMapper;
        this.registrationService = registrationService;
        this.updateUserModelMapper = updateUserModelMapper;
    }


    @GetMapping(value = "/search-user")
    public ResponseEntity<List<RegistrationResponseModel>> search(
            @RequestParam("searchValue") String searchValue
    ){
        List<RegistrationDTO> registrationDTOList = registrationService.searchByLastName(searchValue);
        List<RegistrationResponseModel> registrationResponseModelList = responseModelMapper.toResponseModel(registrationDTOList);    ;
        return ResponseEntity.ok(registrationResponseModelList);
    }

    @PutMapping(value = "/")
    public ResponseEntity<CommonResponse> update(
            @Valid @RequestBody UpdateUserRequest request
            ){
        RegistrationDTO registrationDTO = updateUserModelMapper.toDTO(request);
        System.out.println(request.isAdmin());
        System.out.println(registrationDTO.isAdmin());
        boolean result = registrationService.update(registrationDTO);
        CommonResponse response = new CommonResponse(result, "Update successfully", null);
        return ResponseEntity.ok(response);
    }
    
}
