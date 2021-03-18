package com.example.traum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "booking_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailsEntity extends AbstractEntity{

  @Column(name = "user_id", nullable = false)

  private UserDetailsEntity userId;

  @Column(name = "listing_id", nullable = false)
  private ListingDetailsEntity listingDetailsEntity;

}
