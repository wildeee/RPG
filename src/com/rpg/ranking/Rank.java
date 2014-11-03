package com.rpg.ranking;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rank implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long pk;

    @Column(name = "SCORE", nullable = false)
    private Double score;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Rank() {
        this.pk = null;
        this.score = 0.0;
        this.name = "";
    }

    public Long getPk() {
        return pk;
    }

    public String getScore() {
        String retorno = String.format("%.3f", score);
        return retorno.replace(".", ",");
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
