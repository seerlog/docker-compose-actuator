package com.example.worldgoldassociation.domain.goldStatus.repository;

import com.example.worldgoldassociation.domain.goldStatus.GoldStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoldStatusRepository extends JpaRepository<GoldStatus, Long> {
}
