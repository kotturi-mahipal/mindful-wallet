package com.projects.mindfulwallet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.mindfulwallet.backend.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

}