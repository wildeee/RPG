package com.rpg.entity;

import com.rpg.enums.TipoJogador;

public abstract class Antagonista extends Personagem {

    public Antagonista(TipoJogador tipo) {
        super(tipo);
    }

    @Override
    public Integer getDano() {
        return 2 * this.getNormalDamage();
    }

    protected abstract Integer getNormalDamage();
}
