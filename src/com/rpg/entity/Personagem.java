package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoJogador;

public abstract class Personagem extends Entity {

    private String nome;
    private Integer hp;
    private TipoJogador tipoJogador;
    private Boolean vivo;

    public Personagem(TipoJogador tipo) {
        this.nome = this.getNomeClasse();
        this.hp = this.getMaxHealth();
        this.vivo = true;
        this.tipoJogador = tipo;
    }

    public abstract Integer getDano();

    public abstract Integer getResistencia();

    public abstract Double getChanceResist();

    private Integer calculaValorIncremento(Protagonista healer) {
        Double fator = healer.getFatorHeal();
        Integer valorIncremento = (int) Math.floor(this.getMaxHealth() * fator);
        return valorIncremento;
    }

    public void atacar(Personagem atacado) {
        atacado.tomaDano(this);
    }

    public abstract Integer getMaxHealth();

    public Integer getHp() {
        return this.hp;
    }

    public Boolean isVivo() {
        return this.vivo;
    }

    protected void morre() {
        this.vivo = false;
    }

    private void tomaDano(Personagem damager) {
        Double chance = Math.random();
        if (chance < this.getChanceResist()) {
            this.tomaDanoIntegral(damager.getDano());
        } else {
            this.reagir(damager.getDano());
        }
        this.verificaMorte();
    }

    private void tomaDanoIntegral(Integer damage) {
        this.hp -= damage;
    }

    private void reagir(Integer damage) {
        damage -= this.getResistencia();
        this.hp -= damage;
    }

    private void verificaMorte() {
        if (this.hp < 0) {
            this.hp = 0;
            this.morre();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }

    public TipoJogador getTipoJogador() {
        return tipoJogador;
    }

    protected void restauraVida(Protagonista healer) {
        this.hp += this.calculaValorIncremento(healer);
        this.verificaSobra();
    }

    private void verificaSobra() {
        if (this.hp > this.getMaxHealth()) {
            this.hp = this.getMaxHealth();
        }
    }
    
    public String getDescricaoPersonagem(){
        String retorno = this.getNomeClasse();
        retorno += " / Nome: ";
        retorno += this.getNome();
        retorno += " / HP: ";
        retorno += this.getMaxHealth();
        retorno += " / Dano: ";
        retorno += this.getDano();
        retorno += " / Resistencia: ";
        retorno += this.getResistencia();
        retorno += " / Chance de resistencia: ";
        retorno += this.getChanceResist() * 100;
        retorno += "%";
        if (this instanceof Protagonista){
            Protagonista p = (Protagonista) this;
            retorno += " / Fator de cura: " + p.getFatorHeal() * 100 + "%";
        }
        return retorno;
    }

    public abstract String getNomeClasse();

    public abstract Sexo getGeneroClasse();
}
