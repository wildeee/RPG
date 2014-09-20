package com.rpg.entity;

import com.rpg.enums.TipoJogador;

public abstract class Personagem extends Entity{
    private String nome;
    private Double hp;
    private TipoJogador tipoJogador;
    
    public abstract Integer getDano();
    public abstract Integer getResistencia();
    public abstract void atacar(Personagem atacado);
    public abstract void reagir();
}
