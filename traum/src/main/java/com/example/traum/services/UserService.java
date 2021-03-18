package com.example.traum.services;

import com.example.traum.entity.UserDetailsEntity;
import com.example.traum.repo.reposervice.UserRepoService;
import com.example.traum.request.UserAdditionRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepoService userRepoService;

  public UserDetailsEntity addUser(
      @Valid final UserAdditionRequest userAdditionRequest) {
    UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
    userDetailsEntity.setUserName(userAdditionRequest.getUserName());
    userDetailsEntity.setEmail(userAdditionRequest.getEmail());
    userDetailsEntity.setPhoneNumber(userAdditionRequest.getPhoneNumber());
    userDetailsEntity.setPassword(userAdditionRequest.getPassword());
    userDetailsEntity = userRepoService.createEntity(userDetailsEntity);
    return userDetailsEntity;
  }

}
