package com.rpg.entity;

import com.rpg.enums.Sexo;
import com.rpg.enums.TipoDamage;
import com.rpg.enums.TipoJogador;
import com.rpg.utils.DamageReturn;
import com.rpg.utils.HealReturn;

public abstract class Personagem {

    private String nome;
    private Integer hp;
    private final TipoJogador tipoJogador;
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
        Integer valorIncremento = (int) Math.floor(healer.getHp() * fator);
        return valorIncremento;
    }

    public DamageReturn atacar(Personagem atacado) {
        return atacado.tomaDano(this);
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

    private DamageReturn tomaDano(Personagem damager) {
        Double chance = Math.random();
        int dano;
        TipoDamage tipo;
        if (chance < this.getChanceResist()) {
            this.tomaDanoIntegral(damager.getDano());
            dano = damager.getDano();
            tipo = TipoDamage.INTEGRAL;
        } else {
            dano = this.reagir(damager.getDano());
            tipo = TipoDamage.REDUZIDO;
        }
        this.verificaMorte();
        return new DamageReturn(tipo, this, dano);
    }

    private void tomaDanoIntegral(Integer damage) {
        this.hp -= damage;
    }

    private int reagir(Integer damage) {
        damage -= this.getResistencia();
        this.hp -= damage;
        return damage;
    }

    private void verificaMorte() {
        if (this.hp <= 0) {
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

    protected HealReturn restauraVida(Protagonista healer) {
        int valor = this.calculaValorIncremento(healer);
        this.hp += valor;
        this.verificaSobra();
        return new HealReturn(this, valor);
    }

    private void verificaSobra() {
        if (this.hp > this.getMaxHealth()) {
            this.hp = this.getMaxHealth();
        }
    }

    public String getDescricaoPersonagem() {
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
        if (this instanceof Protagonista) {
            Protagonista p = (Protagonista) this;
            retorno += " / Fator de cura: " + p.getFatorHeal() * 100 + "%";
        }
        return retorno;
    }

    public abstract String getNomeClasse();

    public abstract Sexo getGeneroClasse();
}
