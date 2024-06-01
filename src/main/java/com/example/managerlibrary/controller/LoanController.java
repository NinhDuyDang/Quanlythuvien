package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;
import com.example.managerlibrary.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/add")
    public ResponseEntity<LoansRequest> createLoan(@RequestBody LoansRequest loansRequest) {
        LoansRequest createdLoan = loanService.createLoan(loansRequest);
        return ResponseEntity.ok(createdLoan);
    }


    @GetMapping("/list/{id}")
    public ResponseEntity<LoansResponse> getLoan(@PathVariable int id) {
        Optional<LoansResponse> loansResponseOpt = loanService.getLoan(id);
        if (loansResponseOpt.isPresent()) {
            return ResponseEntity.ok(loansResponseOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/ist")
    public ResponseEntity<List<LoansResponse>> getAllLoans() {
        List<LoansResponse> loansResponses = loanService.getAllLoans();
        return ResponseEntity.ok(loansResponses);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable int id) {
        boolean isDeleted = loanService.deleteLoan(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoansResponse> updateLoan(@PathVariable int id, @RequestBody LoansResponse loansResponse) {
        Optional<LoansResponse> updatedLoansResponseOpt = loanService.updateLoan(id, loansResponse);
        if (updatedLoansResponseOpt.isPresent()) {
            return ResponseEntity.ok(updatedLoansResponseOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
