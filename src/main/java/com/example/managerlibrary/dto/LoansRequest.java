package com.example.managerlibrary.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class LoansRequest {
    private Integer bookId;
    private Integer customerId;
    private String borrowDate;
    private String dueDate;
    private String status;


}
