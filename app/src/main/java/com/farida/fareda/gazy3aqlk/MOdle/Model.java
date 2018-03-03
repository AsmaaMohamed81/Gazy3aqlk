package com.farida.fareda.gazy3aqlk.MOdle;

/**
 * Created by fareda on 26/02/2018.
 */

public class Model {

    int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    String title;
    String desc;
    String cat;
    byte[] img;

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Model(String title, String desc, String cat, byte[] img) {
        this.title = title;
        this.desc = desc;
        this.cat = cat;
        this.img = img;
    }

    public String getCat() {

        return cat;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public byte[] getImg() {

        return img;
    }

    public Model(String title) {
        this.title = title;
    }

    public Model() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}










