package com.shulyaq.google.controller;

import com.shulyaq.google.model.Direction;
import com.shulyaq.google.service.DirectionService;
import com.shulyaq.google.service.RandomDirectionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/random")
public class RandomDirectionController {
    @Autowired
    private RandomDirectionGenerator generator;

    @Autowired
    private DirectionService directionService;

    @RequestMapping("/get")
    public List<Direction> get() {
        return generator.generateDirections();
    }

    @RequestMapping("/get/{count}")
    public List<Direction> get(@PathVariable("count") int count) {
        return generator.generateDirections(count);
    }

    @RequestMapping("/persist")
    public List<Direction> persist() {
        List<Direction> directions = generator.generateDirections();
        List<Direction> resultList = directionService.saveAllDirections(directions);

        return resultList;
    }

    @RequestMapping("/persist/{count}")
     public List<Direction> persist(@PathVariable("count") int count) {
        List<Direction> directions = generator.generateDirections(count);
        List<Direction> resultList = directionService.saveAllDirections(directions);

        return resultList;
    }

    @RequestMapping(value = "/persist/current", method = RequestMethod.POST)
    public List<Direction> persist(@PathVariable("count") List<Direction> directions) {
        return directionService.saveAllDirections(directions);
    }


}
