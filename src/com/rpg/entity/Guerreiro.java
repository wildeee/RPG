package com.rpg.entity;

public class Guerreiro extends Antagonista {

    private static final Integer dano = 85;
    private static final Integer resistencia = 75;
    private static final Double chanceResist = 0.35;
    private static final Integer maxHealth = 1200;

    public Guerreiro(String nome) {
        super(nome);
    }

    @Override
    protected Integer getNormalDamage() {
        return Guerreiro.dano;
    }

    @Override
    public Integer getResistencia() {
        return Guerreiro.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Guerreiro.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Guerreiro.maxHealth;
    }

}