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
import com.example.traum.response.UserAdditionResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class BookingsController {

  @Autowired
  private BookingDetailsRepository bookingDetailsService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ListingRepository listingRepository;

  @Autowired
  private WalletRepository walletRepository;

  @RequestMapping(value = "/booking/{userId}/{listingId}", method = RequestMethod.POST)
  public ServiceResponse<?> addBooking(@PathVariable("userId") Long userId, @PathVariable("listingId") Long listingId) {
    long bookingId;
    try {
      BookingDetailsEntity bookingDetailsEntity = new BookingDetailsEntity();
      UserDetailsEntity userDetailsEntity = userRepository.findById(userId).get();
      bookingDetailsEntity.setUserDetailsEntity(userDetailsEntity);
      ListingDetailsEntity listingDetailsEntity = listingRepository.findById(listingId).get();
      bookingDetailsEntity.setListingDetailsEntity(listingDetailsEntity);
      BookingDetailsEntity response = bookingDetailsService.save(bookingDetailsEntity);
      bookingId = response.getId();
      WalletEntity walletEntity = walletRepository.findByUserDetailsEntityAndUserType(userDetailsEntity,
          UserType.GUEST).get();
      walletEntity.setPoints(walletEntity.getPoints() + 100);
      walletRepository.save(walletEntity);

      WalletEntity walletEntity1 = walletRepository
          .findByUserDetailsEntityAndUserType(listingDetailsEntity.getUserDetailsEntity(), UserType.CUSTOMER).get();
      walletEntity1.setPoints(walletEntity1.getPoints() + 100);
      walletRepository.save(walletEntity1);
    } catch (InternalServerException ex) {
      return new ServiceResponse<BaseMessageResponse>(
          new BaseMessageResponse(false, ex.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ServiceResponse<Long>(bookingId);
  }
}
