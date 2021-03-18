package com.example.traum.repo;

import com.example.traum.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Long> {

}
