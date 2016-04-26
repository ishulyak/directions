package com.shulyaq.google.service;

import com.google.common.collect.Lists;
import com.shulyaq.google.annotation.Directionable;
import com.shulyaq.google.db.DirectionDao;
import com.shulyaq.google.model.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;

@Service
@Directionable
public class DirectionService {
    @Autowired
    private DirectionDao directionDao;

    @Transactional
    public List<Direction> getAllDirections() {
        return newArrayList(directionDao.findAll());
    }

    @Transactional
    public Direction getDirection(String directionId) {
        return directionDao.findOne(valueOf(directionId));
    }

    @Transactional
    public Direction saveDirection(Direction direction) {
        return directionDao.save(direction);
    }

    @Transactional
    public List<Direction> saveAllDirections(List<Direction> directions) {
        return newArrayList(directionDao.save(directions));
    }

    public void setDirectionDao(DirectionDao directionDao) {
        this.directionDao = directionDao;
    }
}
