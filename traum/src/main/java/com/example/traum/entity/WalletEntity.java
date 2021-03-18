package com.example.traum.entity;

import com.example.traum.UserType;
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
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity extends AbstractEntity<Long> {

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserDetailsEntity userId;

  @Column(name = "user_type", nullable = false)
  private UserType userType;

  @Column(name = "points", nullable = true)
  private Integer points;

}
