package com.example.traum.repo;

import com.example.traum.entity.WalletEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

  @Override
  Optional<WalletEntity> findById(Long aLong);

  @Override
  <S extends WalletEntity> S save(S s);

  Optional<WalletEntity> findByUserIdAndUserType(long userId, int userType);
}