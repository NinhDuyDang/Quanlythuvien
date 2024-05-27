package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;
import com.example.managerlibrary.entity.Loans;
import com.example.managerlibrary.repository.LoanRepo;
import com.example.managerlibrary.service.LoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImp implements LoanService {
    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public LoansRequest createLoan(LoansRequest loansRequest) {
        Loans loans = modelMapper.map(loansRequest, Loans.class);
        Loans savedLoans = loanRepo.save(loans);
        return modelMapper.map(savedLoans, LoansRequest.class);
    }

    @Override
    public LoansResponse getLoansResponse(int id) {
        Loans loans = loanRepo.findById(id).orElse(null);
        if (loans != null) {
            return modelMapper.map(loans, LoansResponse.class);
        } else {
            return null; // or throw an exception
        }
    }
}
