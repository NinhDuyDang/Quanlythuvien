package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.dto.LoansRequest;
import com.example.managerlibrary.dto.LoansResponse;
import com.example.managerlibrary.entity.Loans;
import com.example.managerlibrary.repository.LoanRepo;
import com.example.managerlibrary.service.LoanService;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<LoansResponse> getLoan(int id) {
        Optional<Loans> loansOpt = loanRepo.findById(id);
        if (loansOpt.isPresent()) {
            Loans loans = loansOpt.get();
            LoansResponse loansResponse = new LoansResponse();

            // Assuming loans has getBook() and getCustomer() methods
            loansResponse.setTitle(loans.getBooks().getTitle());
            loansResponse.setName(loans.getCustomer().getName());
            loansResponse.setBorrowDate(loans.getBorrowDate());
            loansResponse.setDueDate(loans.getDueDate());
            loansResponse.setStatus(loans.getStatus());

            return Optional.of(loansResponse);
        } else {
            return Optional.empty();
        }


    }

    @Override
    public List<LoansResponse> getAllLoans() {
        List<Loans> loansList = loanRepo.findAll();
        List<LoansResponse> loansResponses = new ArrayList<>();

        for (Loans loan : loansList) {
            LoansResponse response = new LoansResponse();
            response.setTitle(loan.getBooks().getTitle());
            response.setName(loan.getCustomer().getName());
            response.setBorrowDate(loan.getBorrowDate());
            response.setDueDate(loan.getDueDate());
            response.setStatus(loan.getStatus());
            loansResponses.add(response);
        }

        return loansResponses;
    }

    @Override
    public boolean deleteLoan(int id) {
        if (loanRepo.existsById(id)) {
            loanRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<LoansResponse> updateLoan(int id, LoansResponse loansResponse) {
        Optional<Loans> loansOpt = loanRepo.findById(id);
        if (loansOpt.isPresent()) {
            Loans loans = loansOpt.get();

            // Assuming setters for fields
            loans.setBorrowDate(loansResponse.getBorrowDate());
            loans.setDueDate(loansResponse.getDueDate());
            loans.setStatus(loansResponse.getStatus());

            // Save updated entity
            Loans updatedLoans = loanRepo.save(loans);

            // Map updated entity to response
            LoansResponse updatedResponse = new LoansResponse();
            updatedResponse.setTitle(updatedLoans.getBooks().getTitle());
            updatedResponse.setName(updatedLoans.getCustomer().getName());
            updatedResponse.setBorrowDate(updatedLoans.getBorrowDate());
            updatedResponse.setDueDate(updatedLoans.getDueDate());
            updatedResponse.setStatus(updatedLoans.getStatus());

            return Optional.of(updatedResponse);
        }
        return Optional.empty();

    }
}



