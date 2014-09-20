package com.rpg.entity;

public abstract class Protagonista extends Personagem {
    
    public Protagonista(String nome) {
        super(nome);
    }
    
    public abstract Double getFatorHeal();
    
    public void heal(Personagem personagem) {
        personagem.restauraVida(this);
    }
}
