package com.example.traum.repo;

import com.example.traum.entity.ListingDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<ListingDetailsEntity, Long> {

}
