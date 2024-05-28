package com.example.managerlibrary.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
public class Loans implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(name = "bookId", insertable = true, updatable = false)
    private Integer bookId;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId", insertable = false, updatable = false)
    private Books books;

    @Column(name = "customerId", insertable = true, updatable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "borrowDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private String borrowDate;

    @Column(name = "dueDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private String dueDate;

    @Column(name = "status")
    private String status;


}

