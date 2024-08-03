package com.example.managerlibrary.controller;

import com.example.managerlibrary.entity.Cancel;
import com.example.managerlibrary.service.CancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancel")
public class CancelController {
    @Autowired

    private final CancelService cancelService;

    @Autowired
    public CancelController(CancelService cancelService) {
        this.cancelService = cancelService;
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable int id) {
        try {
            Cancel updateStatus = cancelService.updateStatus(id);
            return new ResponseEntity<>("Cancel status updated to NO ACTIVE", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
