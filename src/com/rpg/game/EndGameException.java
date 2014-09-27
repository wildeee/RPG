package com.rpg.game;

class EndGameException extends Exception {

    private final boolean youWin;

    public EndGameException(boolean youWin) {
        this.youWin = youWin;
    }

    public boolean youWin() {
        return this.youWin;
    }

}
