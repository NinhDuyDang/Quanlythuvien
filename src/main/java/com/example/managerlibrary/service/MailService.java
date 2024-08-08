package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendEmail(Employee employee);
}
