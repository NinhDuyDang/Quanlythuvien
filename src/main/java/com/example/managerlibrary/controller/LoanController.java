package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;
import com.example.managerlibrary.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/add")
    public ResponseEntity<LoansRequest> createLoan(@RequestBody LoansRequest loansRequest) {
        LoansRequest createdLoan = loanService.createLoan(loansRequest);
        return ResponseEntity.ok(createdLoan);
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<LoansResponse> getLoanById(@PathVariable int id) {
        LoansResponse loansResponse = loanService.getLoansResponse(id);
        if (loansResponse != null) {
            return ResponseEntity.ok(loansResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
