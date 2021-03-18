package com.example.traum.repo;

import com.example.traum.entity.BookingDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends
    JpaRepository<BookingDetailsEntity, Long> {

  public BookingDetailsEntity save(BookingDetailsEntity bookingDetailsEntity);
}
