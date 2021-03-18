package com.example.traum.controller;


import com.example.traum.entity.UserDetailsEntity;
import com.example.traum.exception.InternalServerException;
import com.example.traum.request.UserAdditionRequest;
import com.example.traum.response.BaseMessageResponse;
import com.example.traum.response.ServiceResponse;
import com.example.traum.services.UserService;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ServiceResponse<?> addUser(
      @Valid @RequestBody UserAdditionRequest userAdditionRequest) {
    log.info("Received request to get expense categories");
    UserDetailsEntity userDetailsEntity;
    try {
      userDetailsEntity = userService.addUser(userAdditionRequest);
    } catch (InternalServerException ex) {
      log.error("MachineManagementController :add Machine - Exception occurred: {}", ex);
      return new ServiceResponse<BaseMessageResponse>(
          new BaseMessageResponse(false, ex.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ServiceResponse<UserDetailsEntity>(userDetailsEntity);
  }


}