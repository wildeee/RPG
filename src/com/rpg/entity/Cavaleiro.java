package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public class Cavaleiro extends Protagonista {

    private static final String nomeClasse = "Cavaleiro";
    private static final Sexo generoClasse = Sexo.MASCULINO;
    private static final Integer dano = 110;
    private static final Integer resistencia = 50;
    private static final Double chanceResist = 0.2;
    private static final Integer maxHealth = 1500;
    private static final Double fatorHeal = 0.2;

    public Cavaleiro(String nome, TipoJogador tipo) {
        super(nome, tipo);
    }

    @Override
    public Integer getDano() {
        return Cavaleiro.dano;
    }

    @Override
    public Integer getResistencia() {
        return Cavaleiro.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Cavaleiro.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Cavaleiro.maxHealth;
    }

    @Override
    public Double getFatorHeal() {
        return Cavaleiro.fatorHeal;
    }

    @Override
    public String getNomeClasse() {
        return Cavaleiro.nomeClasse;
    }

    @Override
    public Sexo getGeneroClasse() {
        return Cavaleiro.generoClasse;
    }

}
