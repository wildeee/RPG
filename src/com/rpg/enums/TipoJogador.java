package com.rpg.enums;

public enum TipoJogador {

    HUMAN("Humano"), CPU("CPU");
    private final String tipo;

    private TipoJogador(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}