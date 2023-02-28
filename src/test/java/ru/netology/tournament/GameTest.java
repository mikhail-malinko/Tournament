package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Игрок 1", 35);
    Player player2 = new Player(2, "Игрок 2", 30);
    Player player3 = new Player(3, "Игрок 3", 35);

    @Test //Раунд когда игрок один сильнее чем игрок два
    public void roundWhenPlayerOneIsStrongerThanPlayerTwo() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Игрок 1", "Игрок 2");

        Assertions.assertEquals(expected, actual);
    }
    @Test //Раунд когда игрок два сильнее чем игрок один
    public void roundWhenPlayerTwoIsStrongerThanPlayerOne () {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Игрок 2", "Игрок 1");

        Assertions.assertEquals(expected, actual);
    }
    @Test //Раунд когда игроки равны по силе
    public void roundWhenThePlayersAreEqual () {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Игрок 1", "Игрок 3");

        Assertions.assertEquals(expected, actual);
    }
    @Test //Раунд когда игрок один не зарегистрирован
    public void roundWhenPlayerOneIsNotRegistered () {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 5", "Игрок 3");
        });
    }
    @Test //Раунд когда игрок два не зарегистрирован
    public void roundWhenPlayerTwoIsNotRegistered () {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 2", "Игрок 5");
        });
    }
    @Test //Раунд когда оба игрока не зарегистрированы
    public void roundWhenPlayersАreNotRegistered () {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 7", "Игрок 5");
        });
    }
}
