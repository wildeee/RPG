package com.rpg.entity;

import com.rpg.enums.TipoJogador;

public abstract class Protagonista extends Personagem {

    public Protagonista(String nome, TipoJogador tipo) {
        super(nome, tipo);
    }

    public abstract Double getFatorHeal();

    public void heal(Personagem personagem) {
        personagem.restauraVida(this);
    }
}
