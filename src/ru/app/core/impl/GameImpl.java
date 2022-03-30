package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

import java.util.Set;

public class GameImpl implements Game {
    private static int MAXIMUM_GAME_POINT = 11;

    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {
        //TODO напиши здесь реализацию игры в пинг-понг двух игроков, используя их имплементации
        // алгоритм реализации:
        // При каждом ударе игрока производится проверка, попал ли игрок по столу соперника или нет.
        // Факт удара фиксируется в console (попал или не попал и по какой точке был совершен удар).
        // В случае, если игрок не попадает по столу соперника, очко присуждается его оппонента (общий счет выводится в консоль).
        // Очко разыгрывается до тех пор, пока один из игроков не промахнется по столу соперника.
        // Очки суммируются и тот, кто наберет первым 11 очков, будет победителем.
        int playerOneCount = 0, playerTwoCount = 0;//счтетчики полученных очков игроками
        String playerHitsNow = "one";//чей ход
        while (playerOneCount < MAXIMUM_GAME_POINT && playerTwoCount < MAXIMUM_GAME_POINT) {
            Set targetPoints = playerHitsNow.equals("one") ?//целевой участок стола для атакующего игрока
                    pingPongTable.getPlayerTwoTablePoints() :
                    pingPongTable.getPlayerOneTablePoints();
            TablePoint hitPoint = playerHitsNow.equals("one") ? playerOne.hit() : playerTwo.hit();//точка попадания
            System.out.print("Player " + playerHitsNow + " hits to " + hitPoint + " and ");
            if (targetPoints.contains(hitPoint)) {
                System.out.println("hit");
            } else {
                if (playerHitsNow.equals("one")) {
                    playerTwoCount++;
                } else {
                    playerOneCount++;
                }
                System.out.println("missed");
                System.out.println("Match score: player1 = " + playerOneCount + ", player2 = " + playerTwoCount);
            }
            playerHitsNow = playerHitsNow.equals("one") ? "two" : "one";
        }
        System.out.println((playerOneCount >= MAXIMUM_GAME_POINT ? "Player1" : "Player2") + " is win");
    }
}