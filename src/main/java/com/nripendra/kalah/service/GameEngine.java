package com.nripendra.kalah.service;

import com.nripendra.kalah.model.Game;
import com.nripendra.kalah.model.Pit;
import com.nripendra.kalah.rule.*;
import org.springframework.stereotype.Component;

@Component
public class GameEngine {

    private final KalahRule chain;
    public GameEngine() {

        this.chain = new StartPitRule();
        chain.setNext(new DistributePitStoneRule())
                .setNext(new EndPitRule())
                .setNext(new GameOver());
    }

    public void play(Game game, Pit pit) {
        this.chain.apply(game, pit);
    }

}
