package com.projects.mindfulwallet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projects.mindfulwallet.backend.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}