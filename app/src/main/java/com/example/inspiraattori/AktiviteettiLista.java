package com.example.inspiraattori;

import java.util.ArrayList;

/**
 * Aktiviteetti -olioista koostuva ArrayList.
 * @author Daniel
 */
public class AktiviteettiLista {
    private static final AktiviteettiLista singleton = new AktiviteettiLista();
    private ArrayList<Aktiviteetti> aktiviteetit;


    static AktiviteettiLista getInstance() {
        return singleton;
    }

    /**
     * Konstruktori, jossa luodaan olion sisäinen ArrayList
     */
    public AktiviteettiLista() {
        aktiviteetit = new ArrayList<Aktiviteetti>();
        aktiviteetit.add(new Aktiviteetti("katsoa elokuvaa?",
                "Ota hyvä asento ja herkkuja. Valitse mieleisesi elokuva, ja nauti"));
        aktiviteetit.add(new Aktiviteetti("soittaa ystävällesi?",
                "Kysy kuulumiasi ystävältäsi. Ole kuuntelevana korvana ja jaa myös omat ilosi ja murheesi!"));
        aktiviteetit.add(new Aktiviteetti("suunnitella seuraavaa matkaasi?",
                "Valitse kiinnostava kohde ja sopiva ajankohta. Keksi matkalle ohjelmaa ja lue vinkkejä netistä."));
        aktiviteetit.add(new Aktiviteetti("järjestellä kuvia viime matkaltasi?",
                "Valitse onnistuneet kuvat, poista pieleen menneet. Järjestele ne yhtenäiseksi kokonaisuudeksi, esimerkiksi diaesityksesi tai jaa läheisillesi sosiaaalisessa mediassa"));
        aktiviteetit.add(new Aktiviteetti("lähteä lenkille?",
                "Kohota kuntoa ja mielentilaa lähtemällä lenkille, Jos et mieli liikkua yksin, kutsu kaveri mukaan!"));
        aktiviteetit.add(new Aktiviteetti("pelata pelejä?",
                "Videopelit, lautapelit, korttipelit. Vaihtoehtoja on lukemattomiin! Valitse mieleinen peli ja pelaa yksin, kaverin kanssa tai porukalla!"));
        aktiviteetit.add(new Aktiviteetti("lukea kirjaa?",
                "Tarkista kirjahyllystäsi, olisiko siellä kiinnostavaa luettavaa. Voit myös käydä kirjastossa! Siellä ei ainakaan ole pulaa lukemisesta ja työntekijät auttavat kirjan valinnassa."));
        aktiviteetit.add(new Aktiviteetti("leipoa tai tehdä ruokaa?",
                "Valitse resepti ruokaan tai leivonnaiseen, jonka voisit valmistaa. Tarkastele myös tämän hetken sesonkeja, silloin raaka-aineet ovat parhaimmillaan!"));
        aktiviteetit.add(new Aktiviteetti("suunnitella seuraavaa juhlaa?",
                "Onko sinun tai läheisesi juhlat tulossa? Suunnitele juhlien ohjelmaa, auta läheistä suunnittelussa tai keksi joku lahja, jonka annat seuraavalla kerralla."));
        aktiviteetit.add(new Aktiviteetti("mennä uimaan?",
                "Kohota kuntoa ja mielentilaa lähtemällä uimaan. Jos et mieli liikkua yksin, kutsu kaveri mukaan!"));
        aktiviteetit.add(new Aktiviteetti("lähteä pyörälenkille?",
                "Kohota kuntoa ja mielentilaa lähtemällä pyöräilemään. Jos et mieli liikkua yksin, kutsu kaveri mukaan!"));
        aktiviteetit.add(new Aktiviteetti("kokeilla seinäkiipeilyä?",
                "Kohota kuntoa ja mielentilaa lähtemällä kiipeilemään. Jos et mieli liikkua yksin, kutsu kaveri mukaan!"));
        aktiviteetit.add(new Aktiviteetti("kuunnella musiikkia?",
                "Kuuntele lempiartistiasi tai revittele ja kuuntele jotain, mitä et ole koskaan ennen kuunnellut. Voit yllättyä positiivisesti!"));
        aktiviteetit.add(new Aktiviteetti("piirtää tai maalata?",
                "Ota värityskirja ja kynät esille. Vaihtoehtoisesti paletti ja maalausteline. Luo taidetta ja nauti!"));
        aktiviteetit.add(new Aktiviteetti("sopia treffit ystävän kanssa?",
                "Pyydä ystävä kahville tai pyydä kylään. Vaihtakaa kuulumisia ja nauttikaa toistenne seurasta. Mukavat hetket läheisten kanssa piristää päivää kummasti!"));
        aktiviteetit.add(new Aktiviteetti("siivota kotiasi",
                "Ota moppi ja luuta käteen ja pistä paikat kiiltämään. Puhdas koti parantaa hyvinvointia tehokkasti."));
        aktiviteetit.add(new Aktiviteetti("tutustua kulttuuriin?",
                "Katso netistä kiinnostavia museoita ja teatteriesityksiä. Valitse itsellesi mieleinen kohde ja ajankohta."));
        aktiviteetit.add(new Aktiviteetti("opiskella uutta kieltä?",
                "Etsi tietoa paikallisista kursseista tai liity nettikurssille. Halutessasi lainaa kirjastosta kielenopiskelukirja."));
    }

    /**
     * Palauttaa aktiviteettilistan
     * @return aktiviteettilista -olio
     */
    public ArrayList<Aktiviteetti> getAktiviteettiLista() {
        return aktiviteetit;
    }

    /**
     * Palautttaa aktiviteetin listalta kohdasta i.
     * @param i Indeksi listalla
     * @return kohdassa i sijaitseva aktiviteetti
     */
    public Aktiviteetti getAktiviteetti(int i) {

        return aktiviteetit.get(i);
    }

    /**
     * Palauttaa listan koon
     * @return Listan koko kokonaislukuna
     *
     */
    public int listanKoko () {
        return aktiviteetit.size();
    }
}