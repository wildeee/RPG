package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public class Clerigo extends Protagonista {

    private static final String nomeClasse = "Clérigo";
    private static final Sexo generoClasse = Sexo.MASCULINO;
    private static final Integer dano = 79;
    private static final Integer resistencia = 35;
    private static final Double chanceResist = 0.30;
    private static final Integer maxHealth = 1000;
    private static final Double fatorHeal = 0.7;

    public Clerigo(TipoJogador tipo) {
        super(tipo);
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

    @Override
    public String getNomeClasse() {
        return Clerigo.nomeClasse;
    }

    @Override
    public Sexo getGeneroClasse() {
        return Clerigo.generoClasse;
    }

}
