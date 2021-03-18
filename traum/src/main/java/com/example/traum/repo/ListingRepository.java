package com.example.traum.repo;

import com.example.traum.entity.ListingDetailsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends
    JpaRepository<ListingDetailsEntity, Long> {

  @Override
  Optional<ListingDetailsEntity> findById(Long aLong);
}
