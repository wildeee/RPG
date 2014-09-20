package com.rpg.entity;

public class Mago extends Protagonista {
    
    private static final Integer dano = 130;
    private static final Integer resistencia = 20;
    private static final Double chanceResist = 0.20;
    private static final Integer maxHealth = 930;
    private static final Double fatorHeal = 0.35;

    public Mago(String nome) {
        super(nome);
    }
    
    @Override
    public Double getFatorHeal() {
        return Mago.fatorHeal;
    }

    @Override
    public Integer getDano() {
        return Mago.dano;
    }

    @Override
    public Integer getResistencia() {
        return Mago.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Mago.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Mago.maxHealth;
    }
    
}
