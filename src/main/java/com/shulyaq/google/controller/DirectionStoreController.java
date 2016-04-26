package com.shulyaq.google.controller;

import com.shulyaq.google.model.Direction;
import com.shulyaq.google.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/direction")
public class DirectionStoreController {

    @Autowired
    private DirectionService directionService;

    @RequestMapping("/get/{id}")
    public Direction getDirection(@PathVariable("id") String id) {
        return directionService.getDirection(id);
    }

    @RequestMapping("/getAll")
    public List<Direction> getDirections() {
        return directionService.getAllDirections();
    }

    @RequestMapping("/store")
    public void storeDirection(Direction direction) {
        directionService.saveDirection(direction);
    }

    public void setDirectionService(DirectionService directionService) {
        this.directionService = directionService;
    }
}
