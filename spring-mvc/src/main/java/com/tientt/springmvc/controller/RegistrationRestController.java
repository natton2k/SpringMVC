package com.tientt.springmvc.controller;

import com.tientt.springmvc.dto.RegistrationDTO;
import com.tientt.springmvc.form.RegisterForm;
import com.tientt.springmvc.mapper.NewResponseModelMapper;
import com.tientt.springmvc.mapper.RegisterFormMapper;
import com.tientt.springmvc.mapper.RegistrationResponseModelMapper;
import com.tientt.springmvc.mapper.UpdateUserModelMapper;
import com.tientt.springmvc.request.UpdateUserRequest;
import com.tientt.springmvc.response.CommonResponse;
import com.tientt.springmvc.responsemodel.NewRegistrationResponseModel;
import com.tientt.springmvc.responsemodel.RegistrationResponseModel;
import com.tientt.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class RegistrationRestController {

    private RegistrationResponseModelMapper responseModelMapper;
    private RegistrationService registrationService;
    private UpdateUserModelMapper updateUserModelMapper;
    private RegisterFormMapper formMapper;
    private Validator validator;
    private NewResponseModelMapper newResponseModelMapper;

    @Autowired
    public RegistrationRestController(RegistrationResponseModelMapper responseModelMapper,
                                      RegistrationService registrationService,
                                      UpdateUserModelMapper updateUserModelMapper,
                                      RegisterFormMapper formMapper,
                                      @Qualifier("registerValidator") Validator validator,
                                        NewResponseModelMapper newResponseModelMapper) {
        this.responseModelMapper = responseModelMapper;
        this.registrationService = registrationService;
        this.updateUserModelMapper = updateUserModelMapper;
        this.formMapper = formMapper;
        this.validator = validator;
        this.newResponseModelMapper = newResponseModelMapper;

    }


    @GetMapping(value = "/search-user")
    public ResponseEntity<List<NewRegistrationResponseModel>> search(
            @RequestParam("searchValue") String searchValue
    ) {
        List<RegistrationDTO> registrationDTOList = registrationService.searchByLastName(searchValue);
        List<NewRegistrationResponseModel> registrationResponseModelList
                = newResponseModelMapper.toResponseModel(registrationDTOList);
        return ResponseEntity.ok(registrationResponseModelList);
    }

    @PutMapping(value = "/")
    public ResponseEntity<CommonResponse> update(
            @Valid @RequestBody UpdateUserRequest request
    ) {
        RegistrationDTO registrationDTO = updateUserModelMapper.toDTO(request);
        boolean result = registrationService.update(registrationDTO);
        CommonResponse response = new CommonResponse(result, "Update successfully", null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<CommonResponse> delete(
            @RequestParam("username") String username
    ) {
        boolean result = this.registrationService.delete(username);
        String message = "Delete fail";
        if (result) {
            message = "Delete successfully";
        }
        CommonResponse response = new CommonResponse(result, message, null);
        return ResponseEntity.ok(response);
    }

//    @InitBinder("registerForm")
//    //@InitBinder
//    private void initBinder(WebDataBinder binder){
//        binder.addValidators(validator);
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> register(
            @Valid @RequestBody RegisterForm form
    ) {
        RegistrationDTO registrationDTO = formMapper.toDTO(form);
        registrationService.createUser(registrationDTO);
        CommonResponse response = new CommonResponse(true, "Create successfully", null);
        return ResponseEntity.ok(response);
    }

}


















