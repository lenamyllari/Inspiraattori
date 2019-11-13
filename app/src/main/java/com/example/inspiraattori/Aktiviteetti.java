package com.example.inspiraattori;

/**
 * Aktiviteetti olio. Jokaisella aktiviteetilla on kaksi String -oliomuuttujaa. Nimi ja kuvaus.
 * @author Daniel
 */
public class Aktiviteetti {

    private String nimi;
    private String kuvaus;

    /**
     * Konstruktori
     * @param nimi Aktiviteetin "nimi", parin sanan pituinen kuvaus.
     * @param kuvaus Pidempi kuvaus ehdotetusta tekemisestä.
     */
    public Aktiviteetti(String nimi, String kuvaus) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
    }

    /**
     * Palauttaa aktiviteetin kuvauksen.
     * @return Aktiviteetin kuvaus merkkijonona
     */
    public String getKuvaus() {
        return kuvaus;
    }

    /**
     * Palauttaa aktiviteetin nimen.
     * @return Aktiviteetin nimi
     */
    @Override
    public String toString() {
        return nimi;
    }
}