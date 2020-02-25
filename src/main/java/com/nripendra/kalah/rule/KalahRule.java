package com.nripendra.kalah.rule;

import com.nripendra.kalah.model.Game;
import com.nripendra.kalah.model.Pit;

public abstract class KalahRule {

    protected KalahRule next;
    public abstract void apply(Game game, Pit currentPit);

    public KalahRule setNext(KalahRule next) {
        this.next = next;
        return next;
    }

}
