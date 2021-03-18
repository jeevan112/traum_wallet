package com.example.traum.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class ListingAdditionRequest {

  @JsonProperty("user_id")
  private Long userId;


}
