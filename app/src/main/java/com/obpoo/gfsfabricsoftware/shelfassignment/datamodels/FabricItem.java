package com.obpoo.gfsfabricsoftware.shelfassignment.datamodels;

public class FabricItem

{
    String articleno;
    String meters;
    String yard;
    String pcsno;
    String bkno;
    String ctno;
    String pono;
    String id;
    String unique_id;
    String fab_id;
    String color;

    public FabricItem(String articleno, String meters, String yard, String pcsno, String bkno, String ctno, String pono, String id, String unique_id, String fab_id, String color, String cartonnumber) {
        this.articleno = articleno;
        this.meters = meters;
        this.yard = yard;
        this.pcsno = pcsno;
        this.bkno = bkno;
        this.ctno = ctno;
        this.pono = pono;
        this.id = id;
        this.unique_id = unique_id;
        this.fab_id = fab_id;
        this.color = color;
        this.cartonnumber = cartonnumber;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public String getYard() {
        return yard;
    }

    public void setYard(String yard) {
        this.yard = yard;
    }

    public String getPcsno() {
        return pcsno;
    }

    public void setPcsno(String pcsno) {
        this.pcsno = pcsno;
    }

    public String getBkno() {
        return bkno;
    }

    public void setBkno(String bkno) {
        this.bkno = bkno;
    }

    public String getCtno() {
        return ctno;
    }

    public void setCtno(String ctno) {
        this.ctno = ctno;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getFab_id() {
        return fab_id;
    }

    public void setFab_id(String fab_id) {
        this.fab_id = fab_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCartonnumber() {
        return cartonnumber;
    }

    public void setCartonnumber(String cartonnumber) {
        this.cartonnumber = cartonnumber;
    }

    String cartonnumber;
}
