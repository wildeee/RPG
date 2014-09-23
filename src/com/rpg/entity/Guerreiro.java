package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public class Guerreiro extends Antagonista {

    private static final String nomeClasse = "Guerreiro";
    private static final Sexo generoClasse = Sexo.MASCULINO;
    private static final Integer dano = 85;
    private static final Integer resistencia = 75;
    private static final Double chanceResist = 0.35;
    private static final Integer maxHealth = 1200;

    public Guerreiro(String nome, TipoJogador tipo) {
        super(tipo);
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

    @Override
    public String getNomeClasse() {
        return Guerreiro.nomeClasse;
    }

    @Override
    public Sexo getGeneroClasse() {
        return Guerreiro.generoClasse;
    }

}
