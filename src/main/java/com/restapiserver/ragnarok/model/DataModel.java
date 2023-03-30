package com.restapiserver.ragnarok.model;

import java.sql.Blob;

public class DataModel {
    private int id;
    private int stat;
    private int posx;
    private int posy;
    private int itemp;
    private String stemp;
    private Blob data;

    public DataModel(int id, int stat, int posx, int posy, int itemp, String stemp, Blob data) {
        this.id = id;
        this.stat = stat;
        this.posx = posx;
        this.posy = posy;
        this.itemp = itemp;
        this.stemp = stemp;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getItemp() {
        return itemp;
    }

    public void setItemp(int itemp) {
        this.itemp = itemp;
    }

    public String getStemp() {
        return stemp;
    }

    public void setStemp(String stemp) {
        this.stemp = stemp;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }

    
}
