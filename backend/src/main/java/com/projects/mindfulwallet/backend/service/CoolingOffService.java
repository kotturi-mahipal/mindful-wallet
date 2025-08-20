package com.projects.mindfulwallet.backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mindfulwallet.backend.model.CoolingOffItem;
import com.projects.mindfulwallet.backend.repository.CoolingOffItemRepository;

@Service
public class CoolingOffService {
    private final CoolingOffItemRepository coolingOffItemRepository;

    @Autowired
    public CoolingOffService(CoolingOffItemRepository coolingOffItemRepository) {
        this.coolingOffItemRepository = coolingOffItemRepository;
    }

    // Retrieve all active cooling-off items
    public List<CoolingOffItem> getActiveItems() {
        return coolingOffItemRepository.findAll();
    }

    public CoolingOffItem startCoolingOff(CoolingOffItem item) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'startCoolingOff'");
        item.setExpiresAt(LocalDateTime.now().plusHours(24));
        return coolingOffItemRepository.save(item);
    }
}