package com.rpg.entity;

import com.rpg.enums.TipoJogador;

public class Necromante extends Antagonista {

    private static final Integer dano = 90;
    private static final Integer resistencia = 30;
    private static final Double chanceResist = 0.19;
    private static final Integer maxHealth = 990;

    public Necromante(String nome, TipoJogador tipo) {
        super(nome, tipo);
    }

    @Override
    protected Integer getNormalDamage() {
        return Necromante.dano;
    }

    @Override
    public Integer getResistencia() {
        return Necromante.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Necromante.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Necromante.maxHealth;
    }
}
