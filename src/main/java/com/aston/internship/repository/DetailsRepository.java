package com.aston.internship.repository;

import com.aston.internship.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Optional<Details> findByUsername(String username);
}
