package com.rpg.enums;

public enum TipoDamage {

    INTEGRAL("integral"), REDUZIDO("reduzido");
    private final String tipo;

    private TipoDamage(String s) {
        this.tipo = s;
    }

    @Override
    public String toString() {
        return this.tipo + ": ";
    }
}
