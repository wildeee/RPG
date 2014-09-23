package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public class Cacador extends Antagonista {

    private static final String nomeClasse = "Caçador";
    private static final Sexo generoClasse = Sexo.MASCULINO;
    private static final Integer dano = 75;
    private static final Integer resistencia = 45;
    private static final Double chanceResist = 0.42;
    private static final Integer maxHealth = 1600;

    public Cacador(String nome, TipoJogador tipo) {
        super(nome, tipo);
    }

    @Override
    protected Integer getNormalDamage() {
        return Cacador.dano;
    }

    @Override
    public Integer getResistencia() {
        return Cacador.resistencia;
    }

    @Override
    public Double getChanceResist() {
        return Cacador.chanceResist;
    }

    @Override
    public Integer getMaxHealth() {
        return Cacador.maxHealth;
    }

    @Override
    public String getNomeClasse() {
        return Cacador.nomeClasse;
    }

    @Override
    public Sexo getGeneroClasse() {
        return Cacador.generoClasse;
    }
}
