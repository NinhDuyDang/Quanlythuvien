package com.example.managerlibrary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoansResponse {

    private String title;
    private String name;
    private String borrowDate;
    private String dueDate;
    private String status;

}
