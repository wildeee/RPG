package com.rpg.entity;

import com.rpg.enums.TipoJogador;
import com.rpg.utils.HealReturn;

public abstract class Protagonista extends Personagem {

    public Protagonista(TipoJogador tipo) {
        super(tipo);
    }

    public abstract Double getFatorHeal();

    public HealReturn heal(Personagem personagem) {
        return personagem.restauraVida(this);
    }
}
