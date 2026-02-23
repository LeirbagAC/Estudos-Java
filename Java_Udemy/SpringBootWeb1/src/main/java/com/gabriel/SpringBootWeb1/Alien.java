package com.gabriel.SpringBootWeb1;

public class Alien {

    private int id;
    private String aname;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                '}';
    }
}
