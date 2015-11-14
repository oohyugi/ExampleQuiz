package com.yogiputra.examplequiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by koba on 11/3/15.
 */
public class Level1Activity extends AppCompatActivity {

    String video;
    EditText jawaban;

    ImageView image;

    FloatingActionButton fab;
    Button kirim;
    int benar = 0, salah = 0, index = 0,acak=0;
    int[] pertanyaan;
    String[] jawab;
    String[] soal;
    String ket;
    Uri uri;
    TextView soa;
    Context context = this;
    Dialog dialog;
    TextView tvbenar, tvsalah, tvscore;
    Button keluar;



    public void onCreate(final Bundle b1) {
        super.onCreate(b1);
        setContentView(R.layout.level1_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        jawaban = (EditText) findViewById(R.id.jawaban);
        image = (ImageView) findViewById(R.id.image);
        soa = (TextView) findViewById(R.id.soal);

        kirim = (Button) findViewById(R.id.kirim);

        soal = new String[]{"1", "2", "3", "4", "5", "6"};
        pertanyaan = new int[]{R.drawable.merah, R.drawable.putih,
                R.drawable.kuning, R.drawable.hijau,
                R.drawable.biru,R.drawable.hitam,};

        jawab = new String[]{"merah", "putih", "kuning", "hijau", "biru", "hitam"};

        image.setImageResource(pertanyaan[0]);




        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String jawab1 = jawaban.getText().toString();
                if (jawab1.equalsIgnoreCase(jawab[index])) {
                    benar++;


                } else {
                    salah++;
                    jawaban.setText("");


                }

                if (index < soal.length - 1) {
                    index++;
                    acak++;

                    soa.setText(soal[index]);
                    image.setImageResource(pertanyaan[index]);
                    jawaban.setText("");


                } else {
                    nilai();
                }
            }


        });
    }

    public void nilai() {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_nilai);
        dialog.setTitle("");
        tvbenar = (TextView) dialog.findViewById(R.id.tvbenar);
        tvsalah = (TextView) dialog.findViewById(R.id.tvsalah);
        tvscore = (TextView) dialog.findViewById(R.id.tvscore);
        keluar = (Button) dialog.findViewById(R.id.keluar);
        tvbenar.setText(String.valueOf(benar));
        tvsalah.setText(String.valueOf(salah));
        final int a, b;
        a = Integer.parseInt(tvbenar.getText().toString());
        b = a * 10;
        tvscore.setText(String.valueOf(b));
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

                startActivity(new Intent(Level1Activity.this, GameActivity.class));
            }
        });
        dialog.show();


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
