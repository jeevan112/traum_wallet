package com.example.traum.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DateTimeUtil {

  public static Long epochTimeNow() {
    return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
  }
}