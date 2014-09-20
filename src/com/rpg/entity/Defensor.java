package com.rpg.entity;

public class Defensor extends Protagonista {

    private static final Integer dano = 60;
    private static final Integer resistencia = 75;
    private static final Double chanceResist = 0.8;
    private static final Integer maxHealth = 1800;
    private static final Double fatorHeal = 0.15;

    public Defensor(String nome) {
        super(nome);
    }

    @Override
    public Integer getDano() {
        return Defensor.dano;
    }

    @Override
    public Integer getResistencia() {
        return Defensor.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Defensor.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Defensor.maxHealth;
    }

    @Override
    public Double getFatorHeal() {
        return Defensor.fatorHeal;
    }
}
