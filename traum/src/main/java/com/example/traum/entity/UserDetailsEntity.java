package com.example.traum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsEntity extends AbstractEntity {

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "name", nullable = false)
  private String userName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "password", nullable = false)
  private String password;


}
