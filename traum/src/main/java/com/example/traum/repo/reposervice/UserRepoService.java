package com.example.traum.repo.reposervice;

import com.example.traum.entity.UserDetailsEntity;
import com.example.traum.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRepoService extends AbstractRepoService<UserDetailsEntity, Long> {

  @Autowired
  private UserRepository repository;

  @Override
  protected JpaRepository<UserDetailsEntity, Long> getRepo() {
    return repository;
  }


}
