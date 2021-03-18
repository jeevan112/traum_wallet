package com.example.traum.controller;

import com.example.traum.entity.ListingDetailsEntity;
import com.example.traum.entity.UserDetailsEntity;
import com.example.traum.exception.InternalServerException;
import com.example.traum.repo.ListingRepository;
import com.example.traum.repo.UserRepository;
import com.example.traum.repo.reposervice.AbstractRepoService;
import com.example.traum.request.ListingAdditionRequest;
import com.example.traum.request.UserAdditionRequest;
import com.example.traum.response.BaseMessageResponse;
import com.example.traum.response.ServiceResponse;
import com.example.traum.services.UserService;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ListingController extends AbstractRepoService<ListingDetailsEntity, Long> {

  @Autowired
  private ListingRepository listingRepository;

  @Autowired
  private UserRepository userRepository;


  @RequestMapping(value = "/listing/add", method = RequestMethod.POST)
  public ServiceResponse<?> addListing(
      @Valid @RequestBody ListingAdditionRequest listingAdditionRequest) {
    ListingDetailsEntity listingDetailsEntity = new ListingDetailsEntity();
    try {
      Optional<UserDetailsEntity> userDetailsEntity = userRepository
          .findById(listingAdditionRequest.getUserId());
      listingDetailsEntity.setUserDetailsEntity(userDetailsEntity.get());
      listingDetailsEntity = listingRepository.save(listingDetailsEntity);
    } catch (InternalServerException ex) {
      return new ServiceResponse<BaseMessageResponse>(
          new BaseMessageResponse(false, ex.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ServiceResponse<ListingDetailsEntity>(listingDetailsEntity);
  }

  @Override
  protected JpaRepository<ListingDetailsEntity, Long> getRepo() {
    return listingRepository;
  }
}
