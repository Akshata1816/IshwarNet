package com.akshata.service.predefined;

import com.akshata.entity.PredefinedMaster;
import com.akshata.repository.PredefinedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredefinedMasterMasterImpl implements PredefinedMasterService {

    @Autowired
    private PredefinedRepository predefinedRepository;

    @Override
    public PredefinedMaster getPredefinedByCodeAndName(String code, String name) {
        PredefinedMaster predefinedMaster = predefinedRepository.findByCodeAndName(code, name);
        return predefinedMaster;
    }
}
