package com.example.inspiraattori;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Kysyy käyttäjältä päänäkymässä käytettävää nimeä
 * Tarkistaa käyttäjän syöttämät merkit, hyväksyy vain kirjaimia
 * "Tallenna" -näppäintä painettaessa sovellus palautuu päänäkymään jossa näkyy nyt käyttäjän nimi
 * @author Lena, Elias
 */
public class AnnaNimi extends AppCompatActivity {
    Button buttonTallenna;
    EditText name;
    public static final String PREFERENCES = "tiedot";
    public static final String PREFERECES_NIMI = "kayttaja";
    private SharedPreferences pref;

    /**
     * @param savedInstanceState Activity Lifecyclen instanssi.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anna_nimi);
        pref = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
    }

    /**
     * Lukee käyttäjän syötteen, tallentaa sen merkkijonoksi.
     * Syötteen tarkistus ehtolauseiden avulla, jos nimi ei kelpaa ohjelma ilmoittaa virheestä.
     * Tyhjä syöte ei kelpaa.
     * Vain aakkoset kelpaavat.
     * Nimimerkki ei voi olla yli 15 merkkiä pitkä.
     *
     * @param view Jos ehdot täyttyvät nimi tallennetaan sharedPreferenceen ja palataan pääruudulle.
     */
    public void onClick(View view) {
        name = findViewById(R.id.annaNimi);

        String nimi = name.getText().toString();
        nimi.trim();

        if (nimi.trim().isEmpty()) {
            name.setError("Nimikenttä ei voi olla tyhjä");

        } else if (!nimi.matches("[a-åA-Å ]+")) {
            name.setError("Käytä vain aakkosia.");

        } else if (nimi.length() > 15) {
            name.setError("Nimi on liian pitkä.");
        } else {
            SharedPreferences.Editor prefEditor = pref.edit();
            prefEditor.putString(PREFERECES_NIMI, nimi);
            prefEditor.apply();

            Intent intent = new Intent();
            intent.putExtra("name", name.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
