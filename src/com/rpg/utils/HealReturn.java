package com.rpg.utils;

import com.rpg.entity.Personagem;
import com.rpg.enums.TipoJogador;

public class HealReturn extends Return {

    public HealReturn(Personagem tipo, int quantia) {
        super(tipo, quantia);
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        if (this.tipoTomador.getTipoJogador().equals(TipoJogador.HUMAN)) {
            mensagem.append("Você");
        } else {
            mensagem.append("O inimigo");
        }
        mensagem.append(" curou ");
        mensagem.append(this.tipoTomador.getNome());
        mensagem.append(" : ");
        mensagem.append(this.hp);
        return mensagem.toString();
    }
}
