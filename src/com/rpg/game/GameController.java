package com.rpg.game;

import com.rpg.entity.Antagonista;
import com.rpg.entity.Bruxa;
import com.rpg.entity.Cacador;
import com.rpg.entity.Cavaleiro;
import com.rpg.entity.Clerigo;
import com.rpg.entity.Guerreiro;
import com.rpg.entity.Mago;
import com.rpg.entity.Necromante;
import com.rpg.entity.Paladino;
import com.rpg.entity.Personagem;
import com.rpg.entity.Protagonista;
import com.rpg.enums.TipoJogador;
import com.rpg.utils.DamageReturn;
import com.rpg.utils.HealReturn;
import com.rpg.utils.InterfaceUtils;
import com.rpg.utils.Return;
import com.rpg.view.Battle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameController {

    private static int contagemBots = 0;
    private static int turnoAtual = 0;
    private static final ArrayList<Personagem> ordemTurnos = new ArrayList<>();

    public static void addPersonagem(Personagem personagem) {
        if (GameController.ordemTurnos.size() < 11) {
            GameController.ordemTurnos.add(personagem);
            GameController.insereInimigo(personagem);
        }
    }

    public static int getTurnoAtual() {
        return GameController.turnoAtual;
    }

    public static int getListSize() {
        return GameController.ordemTurnos.size();
    }

    public static Personagem getPersonagemAtIndex(int index) {
        return GameController.ordemTurnos.get(index);
    }

    public static Personagem getPersonagemTurno() {
        return GameController.ordemTurnos.get(turnoAtual);
    }

    private static void proximoTurno(Battle jf) {

        GameController.incrementaTurno(1);
        while (!GameController.getPersonagemAtIndex(turnoAtual).isVivo()) {
            GameController.incrementaTurno(2);
        }
        InterfaceUtils.imprimeTurnoConsole(jf);
    }

    private static void incrementaTurno(int inc) {
        turnoAtual += inc;
        turnoAtual %= 12;
    }

    public static List<Personagem> getAllPersonagens() {
        return GameController.ordemTurnos;
    }

    private static void insereInimigo(Personagem p) {
        Double random = Math.random();
        Personagem inimigo = null;
        if (p instanceof Protagonista) {
            if (random < 0.25) {
                inimigo = new Mago(TipoJogador.CPU);
            }
            if (random >= 0.25 && random < 0.5) {
                inimigo = new Paladino(TipoJogador.CPU);
            }
            if (random >= 0.5 && random < 0.75) {
                inimigo = new Clerigo(TipoJogador.CPU);
            }
            if (random >= 0.75) {
                inimigo = new Cavaleiro(TipoJogador.CPU);
            }
        } else {
            if (random < 0.25) {
                inimigo = new Necromante(TipoJogador.CPU);
            }
            if (random >= 0.25 && random < 0.5) {
                inimigo = new Guerreiro(TipoJogador.CPU);
            }
            if (random >= 0.5 && random < 0.75) {
                inimigo = new Cacador(TipoJogador.CPU);
            }
            if (random >= 0.75) {
                inimigo = new Bruxa(TipoJogador.CPU);
            }
        }
        inimigo.setNome(GameController.nomeaBot());
        GameController.ordemTurnos.add(inimigo);
    }

    private static String nomeaBot() {
        return "CPU " + ++contagemBots;
    }

    private static void verificaWinLose() throws EndGameException {
        boolean botsMortos = true;
        boolean humanosMortos = true;
        for (Personagem p : ordemTurnos) {
            if (p.getTipoJogador().equals(TipoJogador.HUMAN)) {
                if (p.isVivo()) {
                    humanosMortos = false;
                }
            } else {
                if (p.isVivo()) {
                    botsMortos = false;
                }
            }
        }

        if (botsMortos) {
            throw new EndGameException(true);
        }

        if (humanosMortos) {
            throw new EndGameException(false);
        }
    }

    public static void atacaPersonagem(Battle jf, int num) {
        Personagem turno = GameController.getPersonagemTurno();
        DamageReturn retorno = turno.atacar(GameController.getPersonagemAtIndex(num));
        try {
            GameController.verificaWinLose();
        } catch (EndGameException ex) {
            GameController.fimJogo(jf, ex);
        }
        InterfaceUtils.writelnConsole(jf.getConsole(), retorno.toString());
        GameController.rodadaBots(jf);
    }

    private static void fimJogo(JFrame jf, EndGameException ex) {
        jf.dispose();
        String message;
        if (ex.youWin()) {
            message = "Parabéns! Você ganhou!!!";
        } else {
            message = "Você perdeu.";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private static void rodadaBots(Battle jf) {
        GameController.proximoTurno(jf);
        GameController.acaoBot(jf, GameController.getRandomNumberExceptAtual());
    }

    private static void acaoBot(Battle jf, int num) {
        Return retorno = null;
        if (num % 2 == 0 || GameController.getPersonagemTurno() instanceof Antagonista) {
            Personagem turno = GameController.getPersonagemTurno();
            retorno = turno.atacar(GameController.getPersonagemAtIndex(num));
            try {
                GameController.verificaWinLose();
            } catch (EndGameException ex) {
                GameController.fimJogo(jf, ex);
            }
        } else {
            Personagem turno = GameController.getPersonagemTurno();
            Protagonista healer = (Protagonista) turno;
            retorno = healer.heal(GameController.getPersonagemAtIndex(num));
        }
        InterfaceUtils.writelnConsole(jf.getConsole(), retorno.toString());
        GameController.proximoTurno(jf);
    }

    private static int getRandomNumberExceptAtual() {
        Random rand = new Random();
        int numero = rand.nextInt(12);
        return numero == turnoAtual
                || !GameController.getPersonagemAtIndex(numero).isVivo()
                ? getRandomNumberExceptAtual()
                : numero;
    }

    public static void healPersonagem(Battle jf, int num) {
        Personagem turno = GameController.getPersonagemTurno();
        if (turno instanceof Protagonista) {
            Protagonista healer = (Protagonista) turno;

            HealReturn retorno = healer.heal(GameController.getPersonagemAtIndex(num));
            InterfaceUtils.writelnConsole(jf.getConsole(), retorno.toString());
            GameController.rodadaBots(jf);
        } else {
            JOptionPane.showMessageDialog(jf, "O personagem do turno atual "
                    + "não é um protagonista e não pode curar aliados!!!");
        }

    }
}
