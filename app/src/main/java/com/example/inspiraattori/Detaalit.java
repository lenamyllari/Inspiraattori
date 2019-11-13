package com.example.inspiraattori;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Aktiviteettia tarkasteltaessa hakee listalta aktiviteetin indeksin kohdalta.
 * Sisältää aktiviteettien kuvat listattuna.
 * @author Lena
 */
public class Detaalit extends AppCompatActivity {
    ImageView kuva;

    /**
     * Hakee aktiviteetin kuvauksen.
     * Asettaa oikean kuvan listalta perustuen aktiviteetin indeksiin.
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaalit);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(Lista.EXTRA, 0);
        TextView detalit = (findViewById(R.id.detaalit));

        detalit.setText(AktiviteettiLista.getInstance().getAktiviteetti(i).getKuvaus());

        ImageView kuva = (findViewById(R.id.kuva));

        ArrayList array_image = kuvalista();
        kuva.setImageResource( (Integer)array_image .get(i));

    }

    /**
     * ArrayList, johon tallennetaan sovelluksen käyttämät kuvat.
     * @return Lista kuvista.
     */
    public ArrayList<Integer> kuvalista() {
        ArrayList<Integer> array_image = new ArrayList<Integer>();
        array_image.add(R.drawable.image1);
        array_image.add(R.drawable.image2);
        array_image.add(R.drawable.image3);
        array_image.add(R.drawable.image4);
        array_image.add(R.drawable.image5);
        array_image.add(R.drawable.image6);
        array_image.add(R.drawable.image7);
        array_image.add(R.drawable.image8);
        array_image.add(R.drawable.image9);
        array_image.add(R.drawable.image10);
        array_image.add(R.drawable.image11);
        array_image.add(R.drawable.image12);
        array_image.add(R.drawable.image13);
        array_image.add(R.drawable.image14);
        array_image.add(R.drawable.image15);
        array_image.add(R.drawable.image16);
        array_image.add(R.drawable.image17);
        array_image.add(R.drawable.image18);
        return array_image;
    }

}