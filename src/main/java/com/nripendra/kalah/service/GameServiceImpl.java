package com.nripendra.kalah.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nripendra.kalah.model.Game;
import com.nripendra.kalah.model.Pit;
import com.nripendra.kalah.repository.GameMemoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private final GameMemoryRepository gameMemoryRepository;
    private final GameEngine gameEngine;
    public GameServiceImpl(GameMemoryRepository gameMemoryRepository, GameEngine gameEngine) {
        this.gameMemoryRepository = gameMemoryRepository;
        this.gameEngine = gameEngine;
    }

    /**
     * This method is responsible to initialize new game
     *
     * @param initialPitStoneCount is the initial number of stone.
     * @return Game
     */
    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public Game initGame(Integer initialPitStoneCount) {
        return gameMemoryRepository.create(initialPitStoneCount);
    }


    /**
     * This method is responsible for every new move of the stones from a pit.
     *
     * @param gameId game id
     * @param pitIndex index of the pit
     * @return Game
     */
    @Override
    public Game play(String gameId, Integer pitIndex) {
        log.debug("gameId {}, pitIndex {}",gameId, pitIndex);

        Game game = gameMemoryRepository.findById(gameId);
        Pit pit = game.getBoard().getPitByPitIndex(pitIndex);

        gameEngine.play(game, pit);
        return  game;
    }


    public Game reliable(Integer initialPitStoneCount) {
        return new Game();
    }
}
