package com.rpg.enums;

public enum Sexo {

    MASCULINO("Masculino"), FEMININO("Feminino");

    private final String label;

    private Sexo(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
