package com.rpg.utils;

import com.rpg.entity.Personagem;
import com.rpg.enums.Sexo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceUtils {

    public static void askCharacterName(JFrame jf, Personagem personagem) {
        JOptionPane.showInputDialog(jf,
                InterfaceUtils.getCharacterNameMessage(personagem),
                "Insira o nome!",
                1);
    }

    private static String getCharacterNameMessage(Personagem personagem) {
        String retorno = "Insira o nome de ";
        retorno += personagem.getGeneroClasse() == Sexo.MASCULINO ? "seu " : "sua ";
        retorno += personagem.getNomeClasse();
        return retorno;
    }
}
