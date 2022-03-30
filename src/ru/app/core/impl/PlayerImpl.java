package ru.app.core.impl;

import ru.app.core.Player;

import java.util.Random;
import java.util.Set;

public class PlayerImpl implements Player {

    private final Set<TablePoint> playerTablePoints;
    private final Set<TablePoint> pointsForShouting;
    private final Random random = new Random();

    public PlayerImpl(Set<TablePoint> playerTablePoints, Set<TablePoint> pointsForShouting) {
        this.playerTablePoints = playerTablePoints;
        this.pointsForShouting = pointsForShouting;
    }

    @Override
    public TablePoint hit() {
        //TODO напиши здесь реализацию удара ракеткой,
        // возвращающего рандомную точку из pointsForShouting
        TablePoint[] tablePointsArr = pointsForShouting.stream().toArray(TablePoint[]::new);
        return tablePointsArr[random.nextInt(tablePointsArr.length - 1)];
    }
}