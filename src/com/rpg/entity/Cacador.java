package com.rpg.entity;

public class Cacador extends Antagonista {

    private static final Integer dano = 75;
    private static final Integer resistencia = 45;
    private static final Double chanceResist = 0.42;
    private static final Integer maxHealth = 1600;

    public Cacador(String nome) {
        super(nome);
    }

    @Override
    protected Integer getNormalDamage() {
        return Cacador.dano;
    }

    @Override
    public Integer getResistencia() {
        return Cacador.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Cacador.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Cacador.maxHealth;
    }
}
