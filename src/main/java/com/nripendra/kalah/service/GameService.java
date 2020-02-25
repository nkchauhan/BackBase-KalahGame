package com.nripendra.kalah.service;

import com.nripendra.kalah.model.Game;

public interface GameService {
    Game initGame(Integer numberOfStone);
    Game play(String gameId, Integer pitId);
}
