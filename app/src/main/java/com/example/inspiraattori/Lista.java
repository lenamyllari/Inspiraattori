package com.example.inspiraattori;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Näyttää kaikki listalla olevat aktiviteetit listView -näkymässä.
 * Painamalla aktiviteettia käynnistää aktiviteetin detaalit näkymän.
 * @author Lena
 */
public class Lista extends AppCompatActivity {
    public static final String EXTRA = "com.example.myactivity2.INDEKSI";

    /**
     * ListView näkymä Aktiviteetti -olioista.
     * OnClickListener, joka käynnistää olion indeksin perusteella aktiviteetin jossa näkyy olion tarkemmat tiedot.
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        TextView haluaisitko = (findViewById(R.id.haluasitko));
        ListView listView = (findViewById(R.id.listview));

        haluaisitko.setText(randomKysymys());

        listView.setAdapter(new ArrayAdapter<Aktiviteetti>(this, android.R.layout.simple_list_item_1,
                AktiviteettiLista.getInstance().getAktiviteettiLista()));

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Log.d(TAG, "onItemClick(" + i + ")");
                Intent nextActivity = new Intent (Lista.this,Detaalit.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });
    }

    /**
     * Palauttaa satunnaisen kysymyksen listalta.
     * @return
     */
    public String randomKysymys () {
        int a = KysymysLista.getInstance().kysyListaKoko()-1; //loppuarvo // muuttujan esittely ja arvon asetus

        int randomNumber = (int) (Math.random() * a); //sattunainen indeksi // muuttujan esittely ja arvon asetus

        return KysymysLista.getInstance().getKysymys(randomNumber).toString();
    }
}