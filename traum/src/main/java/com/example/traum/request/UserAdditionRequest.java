package com.example.traum.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserAdditionRequest {

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone_number")
  private String phoneNumber;

  @JsonProperty("password")
  private String password;

}
