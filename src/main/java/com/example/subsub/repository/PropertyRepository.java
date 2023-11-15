package com.example.subsub.repository;

import com.example.subsub.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findTop5ByOrderByExpiredAtAsc();
}