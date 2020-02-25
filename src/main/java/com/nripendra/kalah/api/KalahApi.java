package com.nripendra.kalah.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nripendra.kalah.exception.KalahException;
import com.nripendra.kalah.model.Board;
import com.nripendra.kalah.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Controller class that contains all Kalah end points
 */
@Slf4j
@RestController
@EnableSwagger2
@RequestMapping("/api")
public class KalahApi {

    private final GameService gameService;
    public KalahApi(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * @param numberOfStone
     * @return
     */
    @PostMapping(value = "/games")
    public ResponseEntity initBoard(@RequestParam(name = "stone", defaultValue = "6", required = false) Integer numberOfStone){
        log.debug("Initializing kalah game: Welcome");
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.initGame(numberOfStone));
    }

    /**
     * @param gameId
     * @param pitIndex
     * @return
     */
    @PutMapping("/games/{gameId}/pits/{pitIndex}")
    public ResponseEntity play(@PathVariable String gameId, @PathVariable Integer pitIndex){
        log.debug("From game {}, player {} is moving stone from pit {}",gameId, pitIndex);

        if(pitIndex > Board.PIT_END_INDEX || pitIndex < Board.PIT_START_INDEX){
            throw new KalahException("Pit Index is incorrect");
        }

        if(pitIndex.equals(Board.PLAYER1_HOUSE) || pitIndex.equals(Board.PLAYER2_HOUSE)){
            throw new KalahException("Distribution of house stone is not allowed");
        }

        return ResponseEntity.ok().body(gameService.play(gameId, pitIndex));
    }

/*    @GetMapping("/test")
    public String home(){
        return ("<h1>Welcome</h2>");

    }*/
}
