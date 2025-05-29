package com.microservice.accounts.Controller;

import com.microservice.accounts.Constants.AccountConstants;
import com.microservice.accounts.Service.AccuntService;
import com.microservice.accounts.dto.CustomerDto;
import com.microservice.accounts.dto.ResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Account Controller REST API ", description = "Account Controller CRUD REST API Microservices")
@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountController {

    private AccuntService accuntService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto>createAccount( @Valid @RequestBody CustomerDto customerDto){
      accuntService.createAccount(customerDto);
     return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto>fetchAccount(@RequestParam
            @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be 10 digits")
                                                       String mobileNumber){
        CustomerDto customerDto = accuntService.fetchAccount(mobileNumber);
         return ResponseEntity.status(HttpStatus.OK).body(customerDto); 
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto>updateAccount(@Valid @RequestBody CustomerDto customerDto){
        boolean isUpdated = accuntService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteAccount(@RequestParam
            @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be 10 digits")
                                                        String mobileNumber){
        boolean isDeleted = accuntService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
    }
}
