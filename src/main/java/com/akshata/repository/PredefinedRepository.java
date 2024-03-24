package com.akshata.repository;

import com.akshata.entity.PredefinedMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredefinedRepository extends JpaRepository<PredefinedMaster, Long> {

    public PredefinedMaster findByCodeAndName(String code, String name);

    public List<PredefinedMaster> findByCode(String code);
}
