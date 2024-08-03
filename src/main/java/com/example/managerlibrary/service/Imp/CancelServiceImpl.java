package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.entity.Cancel;
import com.example.managerlibrary.enums.CancelEnum;
import com.example.managerlibrary.repository.CancelRepository;
import com.example.managerlibrary.service.CancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CancelServiceImpl implements CancelService {
    private final CancelRepository cancelRepository;

 @Autowired
    public CancelServiceImpl(CancelRepository cancelRepository) {
        this.cancelRepository = cancelRepository;
    }

    @Override
    public Cancel updateStatus(int id) throws Exception {
        Optional<Cancel> optionalCancel = cancelRepository.findById(id);

        if (optionalCancel.isEmpty()) {
            throw new Exception("Cancel entity not found");
        }

        Cancel cancel = optionalCancel.get();

        if (cancel.getStatus() == CancelEnum.ACTIVE) {
            cancel.setStatus(CancelEnum.NOACTIVE);
            return cancelRepository.save(cancel);
        } else {
            throw new Exception("The status is already NOACTIVE");
        }
    }
}
