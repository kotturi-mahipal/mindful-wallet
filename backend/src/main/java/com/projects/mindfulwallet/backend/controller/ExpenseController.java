package com.projects.mindfulwallet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.mindfulwallet.backend.model.Expense;
import com.projects.mindfulwallet.backend.service.ExpenseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /*
     * Endpoint to create a new expense.
     * Handles POST requests at /api/expenses.
     * 
     * @param expense - The expense data from the request body.
     * 
     * @return The newly created expense.
     */
    @PostMapping()
    public Expense createExpense(@RequestBody Expense expense) {
        // TODO: process POST request
        return expenseService.createExpense(expense);
    }

    /*
     * Endpoint to get all expenses.
     * Handles GET requests to /api/expenses.
     * 
     * @return List of all expenses.
     */
    @GetMapping()
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

}