package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Cancel;
import org.springframework.stereotype.Service;

@Service
public interface CancelService {
    Cancel updateStatus(int id) throws Exception;
}
