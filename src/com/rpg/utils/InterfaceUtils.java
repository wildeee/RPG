package com.rpg.utils;

import com.rpg.entity.Personagem;
import com.rpg.entity.Protagonista;
import com.rpg.enums.Sexo;
import com.rpg.game.GameController;
import com.rpg.view.Battle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class InterfaceUtils {

    public static void preparaTela(JFrame jf) {
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setResizable(false);
    }

    public static void askCharacterName(JFrame jf, Personagem personagem) {
        String nome = JOptionPane.showInputDialog(jf,
                InterfaceUtils.getCharacterNameMessage(personagem),
                "Insira o nome!",
                1);
        personagem.setNome(nome);
        for (Personagem p : GameController.getAllPersonagens()) {
            if (personagem.getNome().equals(p.getNome())) {
                JOptionPane.showMessageDialog(jf, "Já existe um personagem cadastrado com esse nome.\n"
                        + "Por favor, tente outro.");
                askCharacterName(jf, personagem);
                return;
            }
        }

    }

    private static String getCharacterNameMessage(Personagem personagem) {
        String retorno = "Insira o nome de ";
        retorno += personagem.getGeneroClasse() == Sexo.MASCULINO ? "seu " : "sua ";
        retorno += personagem.getNomeClasse();
        return retorno;
    }

    public static void limpaConsole(JTextArea text) {
        text.setText("");
    }

    public static void writelnConsole(JTextArea text, String str) {
        text.setText(text.getText() + str + "\n");
    }

    public static void atualizaCampos(JButton nome, JLabel hp, JLabel damage, JLabel resist,
            JLabel healEffect, JLabel classe, Personagem pers) {
        nome.setText(pers.getNome());
        hp.setText("HP: " + pers.getHp() + "/" + pers.getMaxHealth());
        nome.setEnabled((pers.getHp() > 0));
        damage.setText("Dano: " + pers.getDano().toString());
        resist.setText("Resistência: " + pers.getResistencia().toString());
        classe.setText(pers.getNomeClasse());
        if (pers instanceof Protagonista) {
            Protagonista prot = (Protagonista) pers;
            healEffect.setText("Cura: " + prot.getFatorHeal() * 100 + "%");
        } else {
            healEffect.setVisible(false);
        }
    }

    public static boolean verificaBotaoPressionado(JFrame jf, int botao) {
        if (botao == GameController.getTurnoAtual()) {
            JOptionPane.showMessageDialog(jf, "Impossível fazer qualquer ação ao personagem do turno!");
            return true;
        }
        return false;
    }

    public static void imprimeTurnoConsole(Battle jf) {
        InterfaceUtils.writelnConsole(jf.getConsole(),
                "Turno atual: " + GameController.getPersonagemTurno().getNome());
    }
}
