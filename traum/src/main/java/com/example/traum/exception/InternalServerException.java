package com.example.traum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 5434138727922957238L;

  public InternalServerException(String message) {
    super(message);
  }
}