package org.gabriel;

import jakarta.persistence.*;

import java.util.List;

//Para renomear tableas e colunas
//@Entity(name = "Aliens")           Nome para o HQL
//@Table(name = "tb_alienigenas")    Nome para o Banco de Dados

/* Entity é para o mundo Java (Hibernate), Table é para o mundo do Banco (SQL). */
@Entity
//@Table(name = "alien_table")
public class Alien {

    @Id
    private int aid;
    private String aname;
    //@Transient Para não ser salvo no banco, o hibernate ignora ele
    private String tech;
//    @ManyToMany
    @ManyToMany//(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
