package com.rpg.entity;

import com.rpg.enums.TipoJogador;

public class Bruxa extends Antagonista {

    private static final Integer dano = 100;
    private static final Integer resistencia = 40;
    private static final Double chanceResist = 0.4;
    private static final Integer maxHealth = 1100;

    public Bruxa(String nome, TipoJogador tipo) {
        super(nome, tipo);
    }

    @Override
    protected Integer getNormalDamage() {
        return Bruxa.dano;
    }

    @Override
    public Integer getResistencia() {
        return Bruxa.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Bruxa.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Bruxa.maxHealth;
    }

}
