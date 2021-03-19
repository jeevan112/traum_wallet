package com.example.traum.controller;

import com.example.traum.UserType;
import com.example.traum.entity.BookingDetailsEntity;
import com.example.traum.entity.ListingDetailsEntity;
import com.example.traum.entity.UserDetailsEntity;
import com.example.traum.entity.WalletEntity;
import com.example.traum.exception.InternalServerException;
import com.example.traum.repo.BookingDetailsRepository;
import com.example.traum.repo.ListingRepository;
import com.example.traum.repo.UserRepository;
import com.example.traum.repo.WalletRepository;
import com.example.traum.response.BaseMessageResponse;
import com.example.traum.response.ServiceResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class WalletController {

  @Autowired
  private WalletRepository walletRepository;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "/wallet/{userId}/{userType}", method = RequestMethod.GET)
  public ServiceResponse<?> addBooking(@PathVariable("userId") Long userId, @PathVariable("userType") String userType) {
    WalletEntity walletEntity = null;
    try {
      UserDetailsEntity userDetailsEntity = userRepository.findById(userId).get();
      walletEntity = walletRepository.findByUserDetailsEntityAndUserType(userDetailsEntity,
          userType.equals("owner")? UserType.CUSTOMER : UserType.GUEST).get();

    } catch (InternalServerException ex) {
      return new ServiceResponse<BaseMessageResponse>(
          new BaseMessageResponse(false, ex.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ServiceResponse<WalletEntity>(walletEntity);
  }
}
