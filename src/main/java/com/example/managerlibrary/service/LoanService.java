package com.example.managerlibrary.service;
import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;


public interface LoanService {


    LoansRequest createLoan(LoansRequest loansRequest);

    public LoansResponse getLoansResponse(int id);

}
