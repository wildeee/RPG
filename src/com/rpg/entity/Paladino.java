package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public class Paladino extends Protagonista {

    private static final String nomeClasse = "Paladino";
    private static final Sexo generoClasse = Sexo.MASCULINO;
    private static final Integer dano = 60;
    private static final Integer resistencia = 75;
    private static final Double chanceResist = 0.8;
    private static final Integer maxHealth = 1800;
    private static final Double fatorHeal = 0.15;

    public Paladino(TipoJogador tipo) {
        super(tipo);
    }

    @Override
    public Integer getDano() {
        return Paladino.dano;
    }

    @Override
    public Integer getResistencia() {
        return Paladino.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Paladino.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Paladino.maxHealth;
    }

    @Override
    public Double getFatorHeal() {
        return Paladino.fatorHeal;
    }

    @Override
    public String getNomeClasse() {
        return Paladino.nomeClasse;
    }

    @Override
    public Sexo getGeneroClasse() {
        return Paladino.generoClasse;
    }

}
