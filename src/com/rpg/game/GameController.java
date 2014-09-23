package com.rpg.game;

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
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static int contagemBots = 0;
    private static int turnoAtual = 0;
    private static final ArrayList<Personagem> ordemTurnos = new ArrayList<>();

    public static void addPersonagem(Personagem personagem) {
        if (GameController.ordemTurnos.size() < 10) {
            GameController.ordemTurnos.add(personagem);
            GameController.insereInimigo(personagem);
        }
        
    }

    public static Personagem getPersonagemTurno() {
        return GameController.ordemTurnos.get(turnoAtual);
    }

    public static void proximoTurno() {
        GameController.turnoAtual++;
        if (GameController.turnoAtual > 11) {
            GameController.turnoAtual = 0;
        }
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
}
