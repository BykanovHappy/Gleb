package com.Bykanov.Gleb.domain.repo;

import com.Bykanov.Gleb.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
