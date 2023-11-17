package com.Bykanov.Gleb.domain.repo;

import com.Bykanov.Gleb.domain.entity.Firstname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstnameRepo extends JpaRepository<Firstname, Long> {
    Firstname findByName (String name);
}
