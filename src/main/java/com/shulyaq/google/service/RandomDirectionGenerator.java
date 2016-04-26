package com.shulyaq.google.service;

import com.shulyaq.google.model.Direction;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RandomDirectionGenerator {
    public static final int DEFAULT_STRING_LENGTH = 10;
    public static final int DEFAULT_COUNT = 10;

    private int stringLength = DEFAULT_STRING_LENGTH;
    private int count = DEFAULT_COUNT;

    public List<Direction> generateDirections() {
        return generateDirections(count);
    }

    public List<Direction> generateDirections(int count) {
        Supplier<Direction> supplier = this::generateSingleDirection;

        Stream<Direction> stream = Stream.generate(supplier).limit(count);
        return stream.collect(Collectors.toList());
    }

    public Direction generateSingleDirection() {
        Direction direction = new Direction();
        direction.setName(RandomStringUtils.randomAlphabetic(stringLength));
        return direction;
    }

    public static void main(String[] args) {
        RandomDirectionGenerator rdg = new RandomDirectionGenerator();
        List<Direction> list = rdg.generateDirections(10);

        System.out.println(list);
    }

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
