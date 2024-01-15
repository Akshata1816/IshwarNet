package com.akshata.service.predefined;


import com.akshata.entity.PredefinedMaster;

public interface PredefinedMasterService {

    public PredefinedMaster getPredefinedByCodeAndName(String code, String name);
}
