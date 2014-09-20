package com.rpg.entity;

public abstract class Protagonista extends Personagem{
    private Integer fatorIncremento;
    
    public abstract Double calculaFatorIncremento();
    public abstract void heal(Personagem personagem);
}
