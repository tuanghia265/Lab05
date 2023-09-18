package com.example.lab05;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        ivAnimal = findViewById(R.id.iv_animal);
        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);
        findViewById(R.id.bt_random).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Random r = new Random();
        if (v.getId() == R.id.bt_alpha) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
        } else if (v.getId() == R.id.bt_rotate) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
        } else if (v.getId() == R.id.bt_scale) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
        } else if (v.getId() == R.id.bt_trans) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        } else if (v.getId()==R.id.bt_random) {
            int randNumber=(int)(Math.random()*(4-1+1)+1);
            if (randNumber==1){
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha) );
            } else if (randNumber==2) {
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));
            } else if (randNumber==3) {
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
            } else if (randNumber==4) {
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
            }
        }
    }
}