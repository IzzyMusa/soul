package com.example.soul.controller;

import com.example.soul.service.PickupFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PickupFieldController {

    @Autowired
    PickupFieldService pickupFieldService;

    public Integer getNumberOfPlayers(){
        return pickupFieldService.getNumberOfPlayers().checkedIn;
    }


}
