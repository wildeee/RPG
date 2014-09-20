package com.rpg.entity;

public abstract class Antagonista extends Personagem{

    public Antagonista(String nome) {
        super(nome);
    }
    
    @Override
    public Integer getDano(){
        return 2 * this.getNormalDamage();
    }
    
    protected abstract Integer getNormalDamage();
}
