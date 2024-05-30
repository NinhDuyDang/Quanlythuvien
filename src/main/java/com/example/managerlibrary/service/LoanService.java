package com.example.managerlibrary.service;
import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;

import java.util.List;
import java.util.Optional;


public interface LoanService {


    LoansRequest createLoan(LoansRequest loansRequest);
    Optional<LoansResponse> getLoan(int id);
    List<LoansResponse> getAllLoans();
    boolean deleteLoan(int id);
    Optional<LoansResponse> updateLoan(int id, LoansResponse loansResponse);

}
