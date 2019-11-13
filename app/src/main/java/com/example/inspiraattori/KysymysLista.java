package com.example.inspiraattori;


import java.util.ArrayList;

/**
 * Listan kysymys -olioista.
 * @author Lena
 */
public class KysymysLista {
    private static final KysymysLista singleton = new KysymysLista();
    private ArrayList<Kysymys> kysymykset;

    static KysymysLista getInstance() {
        return singleton;
    }

    /**
     * Kysymyslistan luonti ja kysymysten lisäys.
     */
    public KysymysLista() {
        kysymykset = new ArrayList<Kysymys>();
        kysymykset.add(new Kysymys("Haluaisitko"));
        kysymykset.add(new Kysymys("Jaksaisitko"));
        kysymykset.add(new Kysymys("Kiinnostaisiko"));
        kysymykset.add(new Kysymys("Olisiko kivaa"));
        kysymykset.add(new Kysymys("Mielisitkö"));
        kysymykset.add(new Kysymys("Tekisikö mieli"));
        kysymykset.add(new Kysymys("Pitäisikö nyt"));
    }

    /**
     * Palauttaa indeksin kohdalla olevan kysymyksen.
     * @param i Listan sen hetkinen indeksi.
     * @return Kysymys.
     */
    public Kysymys getKysymys(int i) {
        return kysymykset.get(i);

    }

    /**
     * Palauttaa listankoon.
     * @return int listankoko.
     */
    public int kysyListaKoko() {
        return kysymykset.size();
    }
}