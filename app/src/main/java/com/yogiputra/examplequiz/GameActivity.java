package com.yogiputra.examplequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import at.markushi.ui.CircleButton;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {
CircleButton leve1,level2,level3,level4;

    int score1,score2,score3,score4;

    TextView tv1,tv2,tv3,tv4;
    public void onCreate(Bundle b1){
        super.onCreate(b1);
        setContentView(R.layout.game_activity);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);


        leve1=(CircleButton)findViewById(R.id.level1);
        leve1.setOnClickListener(this);
        level2=(CircleButton)findViewById(R.id.level2);
        level2.setOnClickListener(this);
        level3=(CircleButton)findViewById(R.id.level3);
        level3.setOnClickListener(this);
        level4=(CircleButton)findViewById(R.id.level4);
        level4.setOnClickListener(this);
        tv1=(TextView)findViewById(R.id.score1);
        tv2=(TextView)findViewById(R.id.score2);
        tv3=(TextView)findViewById(R.id.score3);
        tv4=(TextView)findViewById(R.id.score4);
        level2.setEnabled(false);
        level3.setEnabled(false);
        level4.setEnabled(false);
        level2.setImageResource(R.drawable.ic_lock_outline_white_48dp);
        level3.setImageResource(R.drawable.ic_lock_outline_white_48dp);
        level4.setImageResource(R.drawable.ic_lock_outline_white_48dp);







}



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.level1:
                startActivity(new Intent(GameActivity.this,Level1Activity.class));
                break;

        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home){

                startActivity(new Intent(GameActivity.this, MainActivity.class));

        }




        return super.onOptionsItemSelected(item);
    }


}
