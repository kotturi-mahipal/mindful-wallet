package com.projects.mindfulwallet.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mindfulwallet.backend.model.Goal;
import com.projects.mindfulwallet.backend.repository.GoalRepository;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    // Create new savings goal
    // @Param goal - The goal to create
    // @return The saved goal
    public Goal craeteGoal(Goal goal) {
        goal.setCurrentAmount(BigDecimal.ZERO);
        return goalRepository.save(goal);
    }

    // Retrieves all savings goals.
    // @return List of all goals.
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    // Add funds to a specific goal
    // @param goalId - The ID of the goal to update
    // @param amountToAdd - The amount to add to the goal's current balance.
    // @return The updated goal, or null if the goal was not found.
    public Goal addFundsTGoal(Long goalId, BigDecimal amountToAdd) {
        Optional<Goal> optionalGoal = goalRepository.findById(goalId);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            goal.setCurrentAmount(goal.getCurrentAmount().add(amountToAdd));
            return goalRepository.save(goal);
        }

        return null; // * IMPROVEMENT: Update to throw an exception for better error handling
    }
}