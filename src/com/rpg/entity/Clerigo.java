package com.rpg.entity;

public class Clerigo extends Protagonista {

    private static final Integer dano = 79;
    private static final Integer resistencia = 35;
    private static final Double chanceResist = 0.30;
    private static final Integer maxHealth = 1000;
    private static final Double fatorHeal = 0.7;

    public Clerigo(String nome) {
        super(nome);
    }

    @Override
    public Integer getDano() {
        return Clerigo.dano;
    }

    @Override
    public Integer getResistencia() {
        return Clerigo.resistencia;
    }

    @Override
    public Integer getMaxHealth() {
        return Clerigo.maxHealth;
    }

    @Override
    public Double getChanceResist() {
        return Clerigo.chanceResist;
    }

    @Override
    public Double getFatorHeal() {
        return Clerigo.fatorHeal;
    }

}
