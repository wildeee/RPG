package com.rpg.enums;

public enum TipoJogador {

    HUMAN("Humano"), CPU("CPU");
    private final String tipo;

    private TipoJogador(String tipo) {
        this.tipo = tipo;
    }

    public TipoJogador next() {
        switch (this) {
            case HUMAN:
                return CPU;
            case CPU:
                return HUMAN;
            default:
                throw new UnsupportedOperationException("Não implementado.");
        }
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
