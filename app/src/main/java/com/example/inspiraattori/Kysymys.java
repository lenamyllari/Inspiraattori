package com.example.inspiraattori;


/**
 * Kysymys -olio.
 * @author Lena
 */
public class Kysymys {

    private String kysy;

    /**
     * Konstruktori
     * @param kysy
     */
    public Kysymys(String kysy) {
        this.kysy = kysy;
    }

    /**
     * Palauttaa kysymyksen
     * @return
     */
    public String toString(){
        return this.kysy;
    }
}