package com.example.traum.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "listing_id", referencedColumnName = "id")
  private ListingDetailsEntity listingDetailsEntity;

}
