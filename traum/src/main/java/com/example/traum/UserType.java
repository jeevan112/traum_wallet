package com.example.traum;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum UserType {

  @JsonProperty("customer")
  CUSTOMER("customer"),

  @JsonProperty("guest")
  GUEST("guest");

  private String displayName;

  private static Map<String, UserType> stringMap = new HashMap<>();
  private static Map<Integer, UserType> intMap = new HashMap<>();

  static {
    for (UserType UserType : UserType.intMap.values()) {
      stringMap.put(UserType.displayName, UserType);
    }
  }

  public String getValue() {
    return displayName;
  }

  public static UserType getStatus(final String value) {
    return stringMap.get(value);
  }

  public static UserType getStatus(final Integer value) {
    return intMap.get(value);
  }
}