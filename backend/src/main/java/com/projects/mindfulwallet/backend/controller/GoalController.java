package com.projects.mindfulwallet.backend.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.mindfulwallet.backend.model.Goal;
import com.projects.mindfulwallet.backend.service.GoalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/goals")
public class GoalController {
    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    /*
     * Endpoint to create new goals.
     * Handles POST requests to /api/goals.
     * 
     * @param goal - Goal data from the request body.
     * 
     * @return The newly created goal.
     */
    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        // TODO: process POST request

        return goalService.craeteGoal(goal);
    }

    /*
     * Endpoint to get all goals.
     * Handles GET requests to /api/goals.
     * 
     * @return List of all the goals.
     */
    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    /*
     * Endpoint to add funds to a specific goal.
     * Handles POST requests to /api/goals/{id}/add.
     * 
     * @param id - The ID of goal to update.
     * 
     * @param payload - A JSON object containing the amount to add - e.g., {"amount"
     * : "500.00"}
     * 
     * @return The updated goal.
     */
    @PostMapping("/{id}/add")
    public ResponseEntity<Goal> addFundsToGoal(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        BigDecimal amountToadd = new BigDecimal(payload.get("amount"));
        Goal updatedGoal = goalService.addFundsTGoal(id, amountToadd);
        if (updatedGoal != null)
            return ResponseEntity.ok(updatedGoal);
        else
            return ResponseEntity.notFound().build();
    }

}