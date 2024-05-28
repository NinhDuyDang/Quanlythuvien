package com.example.managerlibrary.service;
import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;


public interface LoanService {


    LoansRequest createLoan(LoansRequest loansRequest);

    LoansResponse getLoansResponse(int id);

}
