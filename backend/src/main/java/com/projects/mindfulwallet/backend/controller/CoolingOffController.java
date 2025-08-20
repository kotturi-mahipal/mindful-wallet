package com.projects.mindfulwallet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.mindfulwallet.backend.model.CoolingOffItem;
import com.projects.mindfulwallet.backend.service.CoolingOffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/cooling-off")
public class CoolingOffController {
    private final CoolingOffService coolingOffService;

    @Autowired
    public CoolingOffController(CoolingOffService coolingOffService) {
        this.coolingOffService = coolingOffService;
    }

    /*
     * Endpoint to start a new cooling-off period for an item.
     * Handles POST requests to /api/cooling-off.
     * 
     * @param item - The item data from the request body.
     * 
     * @return The newly created cooling-off item with the expiration timestamp.
     */
    @PostMapping()
    public CoolingOffItem startCoolingOff(@RequestBody CoolingOffItem item) {
        // TODO: process POST request
        return coolingOffService.startCoolingOff(item);
    }

    /*
     * Endpoint to get all active cooling-off items.
     * Handles GET requests to /api/cooling-off.
     * 
     * @return List of all the active cooling-off items.
     */
    @GetMapping()
    public List<CoolingOffItem> getAllActiveItems() {
        return coolingOffService.getActiveItems();
    }

}