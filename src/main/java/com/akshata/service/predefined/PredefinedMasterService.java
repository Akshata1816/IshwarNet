package com.akshata.service.predefined;


import com.akshata.entity.PredefinedMaster;

import java.util.List;
import java.util.Set;

public interface PredefinedMasterService {

    public PredefinedMaster getPredefinedByCodeAndName(String code, String name);

    List<PredefinedMaster> getPredefinedList(String code);
}
