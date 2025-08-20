package com.projects.mindfulwallet.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.mindfulwallet.backend.model.CoolingOffItem;

@Repository
public interface CoolingOffItemRepository extends JpaRepository<CoolingOffItem, Long> {

    // Lists items where the 'expiresAt' time before now.
    List<CoolingOffItem> findByExpiresAtBefore(LocalDateTime now);
}