package com.rpg.utils;

import com.rpg.entity.Personagem;
import com.rpg.enums.TipoDamage;
import com.rpg.enums.TipoJogador;

public class DamageReturn extends Return {

    private final TipoDamage tipoDamage;

    public DamageReturn(TipoDamage tipoDamage, Personagem tipoJogador, int dano) {
        super(tipoJogador, dano);
        this.tipoDamage = tipoDamage;
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Você ");
        if (this.tipoTomador.getTipoJogador().equals(TipoJogador.CPU)) {
            mensagem.append("deu ");
        } else {
            mensagem.append("recebeu ");
        }
        mensagem.append("dano em ");
        mensagem.append(this.tipoTomador.getNome());
        mensagem.append(" : ");
        mensagem.append(this.tipoDamage.toString());
        mensagem.append(hp);
        return mensagem.toString();
    }

}
