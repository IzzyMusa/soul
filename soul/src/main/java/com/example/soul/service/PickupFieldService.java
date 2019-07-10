package com.example.soul.service;

import com.example.soul.model.PickupField;
import com.example.soul.repository.PickupFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PickupFieldService {

    @Autowired
    PickupFieldRepository pickupFieldRepository;

    public Optional<PickupField> getNumberOfPlayers(){
        return pickupFieldRepository.findById(1);
    }
}
