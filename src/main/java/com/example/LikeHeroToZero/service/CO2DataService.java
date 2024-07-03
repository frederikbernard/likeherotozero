package com.example.likeherotozero.service;

import com.example.likeherotozero.model.CO2Data;
import com.example.likeherotozero.repository.CO2DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CO2DataService {

    @Autowired
    private CO2DataRepository co2DataRepository;

    public List<CO2Data> getAllCO2Data() {
        return co2DataRepository.findAll();
    }

    public List<CO2Data> getApprovedCO2Data() {
        return co2DataRepository.findAll().stream()
                .filter(CO2Data::isApproved)
                .collect(Collectors.toList());
    }

    public void save(CO2Data co2Data) {
        co2DataRepository.save(co2Data);
    }

    public void deleteById(Long id) {
        co2DataRepository.deleteById(id);
    }

    public Optional<CO2Data> findById(Long id) {
        return co2DataRepository.findById(id);
    }
}



