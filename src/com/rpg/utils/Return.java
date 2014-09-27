package com.rpg.utils;

import com.rpg.entity.Personagem;

public abstract class Return {

    protected final Personagem tipoTomador;
    protected final int hp;

    public Return(Personagem tomador, int dano) {
        this.tipoTomador = tomador;
        this.hp = dano;
    }

    @Override
    public abstract String toString();
}
