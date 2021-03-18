package com.example.traum.repo;

import com.example.traum.entity.UserDetailsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Long> {

  @Override
  Optional<UserDetailsEntity> findById(Long aLong);
}
