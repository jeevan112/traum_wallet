package com.example.traum.entity;


import com.example.traum.util.DateTimeUtil;
import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;

@Access(AccessType.FIELD)
@MappedSuperclass
@Data
public abstract class AbstractEntity<T> implements Serializable {

  /**
   * this model will be used as a parent model for generating the unique id  and storing the created at and updated at.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "created_at", nullable = false)
  private Long createdAt;

  @Column(name = "updated_at", nullable = false)
  private Long updatedAt;



  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = DateTimeUtil.epochTimeNow();
  }

  @PrePersist
  protected void onCreate() {
    this.updatedAt = DateTimeUtil.epochTimeNow();
    this.createdAt = DateTimeUtil.epochTimeNow();
  }

}