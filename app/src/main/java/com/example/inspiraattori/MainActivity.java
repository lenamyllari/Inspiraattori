package com.example.inspiraattori;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.inspiraattori.R.layout.activity_main;

/**
 * Sovelluksen aloitusnäkymä. Kysyy käyttäjältä nimeä, jos sharedPreferences on tyhjä.
 * Voi tarkastella kaikkia listalla olevia aktiviteetteja.
 * Nimen resetointi, jolloin sovellus kysyy nimeä uudestaan.
 * Aktiviteettien selaus ja tarkemmat tiedot sitä painamalla.
 *
 * @author Lena, Elias
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFERENCES = "tiedot";
    public static final String PREFERENCES_INDEKSI = "0";
    public static final String EXTRA = "com.example.myactivity2.INDEKSI";
    private static final String TAG = "testi";
    public String nimi;
    ImageButton imageButtonLeft, imageButtonRight, imageButtonList, imageButttonReset;
    TextView tervehdys, kysytaan, tekemista;
    private int aktIndeksi;
    private SharedPreferences pref;

    /**
     * Sovelluksen käynnistyessä tapahtuva metodikutsu.
     * Määritelläänn widgetit ja luetaan sharedPreferenceistä aktiviteettilistan indeksi sekä käyttäjän nimi.
     * Indeksi on oletuksena nolla. Jos käyttäjän nimeä ei löydy käynnistetään uusi näkymä jossa kysytään käyttäjänimi.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        imageButtonLeft = (findViewById(R.id.imageButtonPrev));
        imageButtonRight = (findViewById(R.id.imageButtonNext));
        imageButtonList = (findViewById(R.id.imageButtonList));
        imageButttonReset = (findViewById(R.id.imageButtonReset));

        tekemista = (findViewById(R.id.tekemista));
        tervehdys = (findViewById(R.id.tervehdys));
        kysytaan = (findViewById(R.id.kysytaan));

        imageButtonLeft.setOnClickListener(this);
        imageButtonRight.setOnClickListener(this);
        imageButtonList.setOnClickListener(this);
        imageButttonReset.setOnClickListener(this);

        tekemista.setOnClickListener(this);

        tekemista.setPaintFlags(tekemista.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        pref = getSharedPreferences(PREFERENCES_INDEKSI, Activity.MODE_PRIVATE);
        //if (pref.equals("0")) {
          //  aktIndeksi = 0;
        //} else {
            aktIndeksi = pref.getInt(PREFERENCES_INDEKSI, 0);
        //}

        //Log.d(TAG, "onCreate: indeksi haettu asetuksista");

        kysytaan.setText(randomKysymys());

        tekemista.setText(AktiviteettiLista.getInstance().getAktiviteetti(aktIndeksi).toString());

        //Log.d(TAG, "onCreate: tekstikentät kunnossa");

        pref = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        if (pref.contains("kayttaja")) {
            tervehdys.setText("Moi, " + pref.getString("kayttaja", "") + "!");
        } else {
            Intent intentNimi = new Intent(this, AnnaNimi.class);
            startActivityForResult(intentNimi, 1);
        }
    }

    /**
     * Tähän palataan kun käyttäjä on syöttänyt nimensä. Metodi saa nimen merkkijonona ja asettaa sen "tervehdys" - tekstikenttään.
     *
     * @param requestCode Varmistaa mistä aktiviteetistä palataan.
     * @param resultCode  Kertoo onnistuiko sovellus.
     * @param data        startActivityForResultista tuleva tieto. Käyttjän nimi merkkijonona.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "requestCode: " + requestCode + " resultCode: " + resultCode);

        super.onActivityResult(requestCode, resultCode, data);

        pref = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);

        if (resultCode == RESULT_OK) {
            nimi = data.getStringExtra("name");
        } else {
            nimi = pref.getString("kayttaja", "");
        }
        //String name = data.getStringExtra("name");
        tervehdys.setText("Moi, " + nimi + "!");
    }

    /**
     * Päänäkymän viiden eri näppäin toiminnot. Toiminnoista yksi tapahtuu riippuen painetusta näppäimestä.
     * Painetun näppäinmen Id -haetaan ja annetaan switch-case -rakenteelle, jossa on metodikutsu tai uuden näkymän käynnistys
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonPrev:
                Log.d(TAG, "prev painettu");
                prev(view);
                break;
            case R.id.imageButtonNext:
                Log.d(TAG, "next painettu");
                next(view);
                break;
            case R.id.imageButtonList:
                Log.d(TAG, "list painettu");
                Intent intentList = new Intent(this, Lista.class);
                startActivity(intentList);
                break;
            case R.id.tekemista:
                Log.d(TAG, "aktiv. painettu");
                Intent intent = new Intent(this, Detaalit.class);
                intent.putExtra(EXTRA, aktIndeksi);
                startActivity(intent);
                break;
            case R.id.imageButtonReset:
                Log.d(TAG, "reset painettu");
                Intent intentNimi = new Intent(this, AnnaNimi.class);
                startActivityForResult(intentNimi, 1);
                break;
        }
    }

    /**
     * Hakee listalta satunnaisen kysymyksen.
     *
     * @return Kysymys -merkkijono
     */
    public String randomKysymys() {
        int a = KysymysLista.getInstance().kysyListaKoko() - 1;

        int randomNumber = (int) (Math.random() * a);

        return KysymysLista.getInstance().getKysymys(randomNumber).toString();
    }

    /**
     * Vertaa indeksiä ja listan kokoa. Indeksi nollaantuu kun lista on käyty läpi.
     * Indeksin tallennus.
     * Hakee seuraavan aktiviteetin ja asettaa sen sekä satunnaisen kysymyksen aiempien tilalle.
     *
     * @param view
     * @author Elias
     */
    public void next(View view) {
        if (aktIndeksi == AktiviteettiLista.getInstance().listanKoko() - 1) {
            aktIndeksi = 0;
        } else {
            aktIndeksi++;
        }
        tallenna();

        kysytaan.setText(randomKysymys());
        tekemista.setText(AktiviteettiLista.getInstance().getAktiviteetti(aktIndeksi).toString());

    }

    /**
     * Jos indeksi on nolla, eli näkyvillä on ensimmäinen aktiviteetti hyppää indeksi listan viimeisen kohdalle.
     * Indeksin tallennus.
     * Hakee edellisen aktiviteetin listalta ja asettaa sen sekä satunnaisen kysymyksen aiempien tilalle.
     *
     * @param view
     * @author Elias
     */
    public void prev(View view) {
        if (aktIndeksi == 0) {
            aktIndeksi = AktiviteettiLista.getInstance().listanKoko() - 1;
        } else {
            aktIndeksi--;
        }
        tallenna();

        kysytaan.setText(randomKysymys());
        tekemista.setText(AktiviteettiLista.getInstance().getAktiviteetti(aktIndeksi).toString());
    }

    /**
     * Tallentaa nykyisen indeksin SharedPreferencesseihin.
     *
     * @author Elias
     */
    public void tallenna() {
        SharedPreferences.Editor prefEditor = getSharedPreferences(PREFERENCES_INDEKSI, MODE_PRIVATE).edit();
        prefEditor.putInt(PREFERENCES_INDEKSI, aktIndeksi);
        prefEditor.apply();

    }

}

